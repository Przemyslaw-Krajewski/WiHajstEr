package com.przemo.model;

import java.util.ArrayList;
import java.util.List;

public class AskQuestionModel
{
    private List<QuestionAnswerModel> recentQuestions = new ArrayList<>();

    private List<String> itemsList = new ArrayList<>();

    public List<QuestionAnswerModel> getRecentQuestions()
    {
        return recentQuestions;
    }

    public void setRecentQuestions(List<QuestionAnswerModel> recentQuestions)
    {
        this.recentQuestions = recentQuestions;
    }

    public List<String> getItemsList()
    {
        return itemsList;
    }

    public void setItemsList(List<String> itemsList)
    {
        this.itemsList = itemsList;
    }
}
