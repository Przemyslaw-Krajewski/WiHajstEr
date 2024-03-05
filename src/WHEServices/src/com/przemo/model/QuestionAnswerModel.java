package com.przemo.model;

public class QuestionAnswerModel
{
    private String question = "";

    private String answer = "";

    public String getQuestion()
    {
        if(this.question==null) this.question="";
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    @Override
    public String toString()
    {
        return question+","+answer;
    }

    public static QuestionAnswerModel fromString(String s)
    {
        QuestionAnswerModel m = new QuestionAnswerModel();
        String[] t = s.split(",");
        m.setQuestion(t[0]);
        m.setAnswer(t[1]);
        return m;
    }
}
