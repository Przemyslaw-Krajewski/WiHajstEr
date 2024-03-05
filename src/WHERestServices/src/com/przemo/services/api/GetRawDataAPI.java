package com.przemo.services.api;

import com.przemo.dao.DataRepository;
import com.przemo.entity.Answer;
import com.przemo.entity.Item;
import com.przemo.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRawDataAPI
{
    @Autowired
    DataRepository dataRepository;

    @RequestMapping(path="/testme", method = {RequestMethod.GET,RequestMethod.POST})
    String testMe()
    {
        return "Heheszki " + System.currentTimeMillis() ;
    }

    @RequestMapping(path="/getquestion", method = {RequestMethod.GET})
    List<Question> getQuestion()
    {
        return dataRepository.getQuestions();
    }

    @RequestMapping(path="/getitem", method = {RequestMethod.GET})
    List<Item> getItem()
    {
        return dataRepository.getItems();
    }

    @RequestMapping(path="/getanswer", method = {RequestMethod.GET})
    List<Answer> getAnswer()
    {
        return dataRepository.getAnswers();
    }
}
