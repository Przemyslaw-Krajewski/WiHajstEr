package com.przemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question", schema = "przemo")
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "questiongenerator")
    @SequenceGenerator(name = "questiongenerator", schema = "przemo", sequenceName = "questionseq",allocationSize = 1)
    private Long id;

    private String question;


    @OneToMany
    @JoinColumn(name = "questionid")
    private List<Answer> answers;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public List<Answer> getAnswers()
    {
        return answers;
    }

    public void setAnswers(List<Answer> answers)
    {
        this.answers = answers;
    }
}
