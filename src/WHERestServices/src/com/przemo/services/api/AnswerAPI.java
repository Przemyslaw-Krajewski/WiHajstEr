package com.przemo.services.api;

import com.przemo.ProvideDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnswerAPI
{

    @Autowired
    ProvideDataService provideDataService;

    @RequestMapping(path = "/create/answers",method = RequestMethod.GET)
    String chooseItem(ModelMap map)
    {
        map.put("list",provideDataService.getItemsList());
        return "createAnswersChooseItem";
    }

    @RequestMapping(path = "/create/answers/{name}",method = RequestMethod.POST)
    String provideAnswers(@PathVariable String name, ModelMap map)
    {
        map.put("list",provideDataService.getUnasweredQuestionsList(name));
        map.put("itemname",name);
        return "createAnswersProvideQuestions";
    }

    @RequestMapping(path = "/provide/answers",method = RequestMethod.GET)
    String provideAnswers2(@RequestParam String itemname, ModelMap map)
    {
        map.put("questions",provideDataService.getUnasweredQuestionsList(itemname));
        map.put("itemname",itemname);
        return "createAnswersProvideQuestions";
    }

    @RequestMapping(path = "/provide/answers",method = RequestMethod.POST)
    String createAnswers(@RequestBody MultiValueMap<String, String> formData, ModelMap map)
    {
        String itemName = formData.getFirst("itemname");
        List<String> questions = new ArrayList<>();
        Integer i = 0;
        while(formData.get("question"+i) != null)
        {
            questions.add(formData.getFirst("question"+i));
            i++;
        }
        List<String> answers = new ArrayList<>();
        i = 0;
        while(formData.get("answer"+i.toString()) != null)
        {
            answers.add(formData.getFirst("answer"+i));
            i++;
        }
        ProvideDataService.Response r = provideDataService.createAnswers(itemName, questions, answers);
        map.put("result",r.toString());
        return "createAnswersResult";
    }
}
