package com.przemo;

import com.przemo.dao.QuestionRepository;
import com.przemo.entity.Answer;
import com.przemo.entity.Item;
import com.przemo.entity.Question;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.przemo.dao.DataRepository;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProvideDataService
{
    @Autowired
    DataRepository dataRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Transactional
    public Response createItem(String name)
    {
        if(dataRepository.getItemByName(name) != null)
        {
            return Response.ALREADY_EXISTS;
        }

        Item item = new Item();
        item.setName(name);
        dataRepository.createEntity(item);

        return Response.SUCCESS;
    }

    @Transactional
    public Response createQuestion(String question)
    {
        if(dataRepository.getQuestionByQuestion(question) != null)
        {
            return Response.ALREADY_EXISTS;
        }

        Question entity = new Question();
        entity.setQuestion(question);
        dataRepository.createEntity(entity);

        return Response.SUCCESS;
    }

    @Transactional
    public List<String> getItemsList()
    {
        return dataRepository.getItems().stream().map(p->p.getName()).collect(Collectors.toList());
    }

    @Transactional
    public List<String> getUnasweredQuestionsList(String name)
    {
        return questionRepository.getUnansweredQuestions(name);
    }

    @Transactional
    public Response createAnswers(String itemName, List<String> questions, List<String> answers)
    {
        if(questions==null || answers==null || questions.size() != answers.size() || questions.size()<=0)
        {
            return Response.ERROR;
        }

        Item item = dataRepository.getItemByName(itemName);
        if(item == null)
        {
            return Response.ERROR;
        }

//        IntStream.range(0,questions.size())
//                .mapToObj(i-> new QuestionAnswer(dataRepository.getQuestionByQuestion(questions.get(i)),answers.get(i)))
//                .filter(p->p.getQ()==null)
//                .map(p->{Answer a = new Answer();
//                         a.setQuestionId(p.getQ().getId());
//                         a.setItem(item);
//                         a.setAnswer(p.getA());
//                         return a;})
//                .forEach(p->dataRepository.createEntity(p));

        Iterator<String> aIt = answers.listIterator();
        Iterator<String> qIt = questions.listIterator();
        while(aIt.hasNext() && qIt.hasNext())
        {
            String questionName = qIt.next();
            String answer = aIt.next();
            Question question = dataRepository.getQuestionByQuestion(questionName);
            if(question != null)
            {
                Answer entity = new Answer();
                entity.setQuestionId(question.getId());
                entity.setItem(item);
                entity.setAnswer(answer);
                dataRepository.createEntity(entity);
            }
        }

        return Response.SUCCESS;
    }

    public enum Response {SUCCESS, ALREADY_EXISTS, ERROR}

    public class QuestionAnswer
    {
        private Question q;
        private String a;

        QuestionAnswer(Question q, String a)
        {
            this.q = q;
            this.a = a;
        }

        public Question getQ()
        {
            return q;
        }

        public void setQ(Question q)
        {
            this.q = q;
        }

        public String getA()
        {
            return a;
        }

        public void setA(String a)
        {
            this.a = a;
        }
    }

}
