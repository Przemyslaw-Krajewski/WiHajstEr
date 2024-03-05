package com.przemo;

import com.przemo.dao.DataRepository;
import com.przemo.dao.QuestionRepository;
import com.przemo.entity.Question;
import com.przemo.model.AskQuestionModel;
import com.przemo.model.QuestionAnswerModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AskQuestionService
{
    @Autowired
    DataRepository dataRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Transactional
    public AskQuestionModel initModel()
    {
            AskQuestionModel model = new AskQuestionModel();
            model.setItemsList(dataRepository.getItems().stream()
                    .map(p->p.getName())
                    .collect(Collectors.toList()));
            return model;
    }

    public void processProvidedAnswer(AskQuestionModel model, String questionName, String answer)
    {
        if(questionName == null || answer == null)
        {
            return;
        }
        QuestionAnswerModel questionAnswerModel = new QuestionAnswerModel();
        questionAnswerModel.setQuestion(questionName);
        questionAnswerModel.setAnswer(answer);

        model.getRecentQuestions().add(questionAnswerModel);

        //Remove items list not fitting to answer
        Question question = dataRepository.getQuestionByQuestion(questionName);
        question.getAnswers().stream()
                .filter((p->(!p.getAnswer().equals(answer))))
                .forEach(p->model.getItemsList().remove(p.getItem().getName()));

    }

    @Transactional
    public String askSingleQuestion(AskQuestionModel model)
    {
        //Getting list of questions from DB
        List<String> questionsToAsk;
        if(model.getItemsList().size() > 5)
        {
            questionsToAsk = questionRepository.getQuestionsByDetailLevel();
        }
        else
        {
            List<String> itemsList = model.getItemsList();
            questionsToAsk = questionRepository.getQuestionsByDetailLevelAndItems(itemsList,itemsList.size());
        }

        //Reviewing already asked questions
        List<String> askedQuestions = model.getRecentQuestions().stream().map(p->p.getQuestion()).collect(Collectors.toList());
        String questionToAsk = null;
        for(String question : questionsToAsk)
        {
            boolean found = false;
            for(int i=0; i<askedQuestions.size();i++)
            {
                if (askedQuestions.get(i).equals(question))
                {
                    askedQuestions.remove(i);
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                questionToAsk = question;
                break;
            }
        }

        //Processing chosen question
        return questionToAsk;

    }
}
