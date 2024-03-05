package com.przemo.services.api;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.przemo.AskQuestionService;
import com.przemo.model.AskQuestionModel;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AskAPI
{
    @Autowired
    AskQuestionService askQuestionService;

//    @RequestMapping(path="/ask", method = RequestMethod.GET)
//    public String askInitial(ModelMap map)
//    {
//        AskQuestionModel model = askQuestionService.initModel();
//        ObjectWriter writer = new ObjectMapper().writer();
//        try
//        {
//            map.put("obiekt", StringEscapeUtils.escapeHtml(writer.writeValueAsString(model)));
//        } catch (JsonProcessingException e)
//        {
//            throw new RuntimeException(e);
//        }
//        return "askQuestion";
//    }
    @RequestMapping(path="/ask", method = {RequestMethod.POST,RequestMethod.GET})
    public String ask(@RequestParam MultiValueMap requestValues, ModelMap map)
    {
        AskQuestionModel model;
        String questionToAsk;
        try
        {
            //Read Object
            ObjectMapper reader = new ObjectMapper();
            String stringModel = (String) requestValues.getFirst("AskQuestionModel");
            String question = (String) requestValues.getFirst("question");
            String answer = (String) requestValues.getFirst("answer");
            if(stringModel==null)
            {
                model = askQuestionService.initModel();
            }
            else
            {
                model = reader.readValue(stringModel, AskQuestionModel.class);
            }

            //Process answer
            askQuestionService.processProvidedAnswer(model,question,answer);
            //Answer one question
            questionToAsk = askQuestionService.askSingleQuestion(model);

            //Write Object
            ObjectWriter writer = new ObjectMapper().writer();
            map.put("AskQuestionModel", StringEscapeUtils.escapeHtml(writer.writeValueAsString(model)));
            map.put("QuestionToAsk",questionToAsk);
        } catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }



        if(model.getItemsList().size() > 1 && questionToAsk != null)
        {
            return "askQuestion";
        }
        else
        {
            if(model.getItemsList().size() == 1)
                map.put("result","Did you mean: " + model.getItemsList().get(0));
            else if(model.getItemsList().size() > 1)
                map.put("result","I think the item you mean is one of: " + model.getItemsList());
            else if(model.getItemsList().size() == 0)
                map.put("result","I do not know what do you mean");
            return "askQuestionResult";
        }
    }
}
