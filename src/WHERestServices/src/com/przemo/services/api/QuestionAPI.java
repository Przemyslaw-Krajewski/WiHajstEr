package com.przemo.services.api;

import com.przemo.ProvideDataService;
import com.przemo.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionAPI
{
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    ProvideDataService provideDataService;

    @RequestMapping(path = "/create/question",method = {RequestMethod.GET})
    String createQuestionForm()
    {
        return "createQuestion";
    }

    @RequestMapping(path = "/create/question",method = {RequestMethod.POST})
    String createQuestion(@RequestParam String question, ModelMap map)
    {
        ProvideDataService.Response r = provideDataService.createQuestion(question);
        map.put("result",r.toString());
        return "createQuestionResult";
    }

    @RequestMapping(path = "/count")
    String countQuestions()
    {
        return Long.toString(questionRepository.getQuestionCount());
    }
}
