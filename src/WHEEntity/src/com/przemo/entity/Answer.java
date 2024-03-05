package com.przemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer", schema = "przemo")
public class Answer
{
    @Id
    @SequenceGenerator(name = "answergenerator",schema = "przemo", sequenceName = "answerseq" , allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="answergenerator")
    Long id;

    @Column(name = "itemid",insertable=false, updatable=false)
    Long itemId;


    @Column(name = "questionid")
    Long questionId;

//    @ManyToOne(fetch = FetchType.EAGER) // Eager needed for json casting
//    @JoinColumn(name = "questionid")
//    Question question;

    @ManyToOne(fetch = FetchType.EAGER) // Eager needed for json casting
    @JoinColumn(name = "itemid")
    Item item;

    String answer;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public Long getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
    }

    //    public Question getQuestion()
//    {
//        return question;
//    }
//
//    public void setQuestion(Question question)
//    {
//        this.question = question;
//    }


    public Long getItemId()
    {
        return itemId;
    }

    public void setItemId(Long itemId)
    {
        this.itemId = itemId;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }
}
