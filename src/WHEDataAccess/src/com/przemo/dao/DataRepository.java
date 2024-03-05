package com.przemo.dao;

import com.przemo.entity.Answer;
import com.przemo.entity.Item;
import com.przemo.entity.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class DataRepository
{
    @PersistenceContext
    EntityManager entityManager;


    public List<Question> getQuestions()
    {
        Query query = entityManager.createQuery("from com.przemo.entity.Question");
        return (List<Question>) query.getResultList();
    }

    public Question getQuestionByQuestion(String question)
    {
        Query query = entityManager.createQuery("from com.przemo.entity.Question where question=:question");
        query.setParameter("question",question);
        Iterator it = query.getResultList().iterator();
        return it.hasNext() ? (Question) it.next() : null;
    }

    public List<Item> getItems()
    {
        Query query = entityManager.createQuery("from com.przemo.entity.Item");
        return (List<Item>) query.getResultList();
    }

    public Item getItemByName(String name)
    {
        Query query = entityManager.createQuery("from com.przemo.entity.Item where name=:name");
        query.setParameter("name",name);
        Iterator it = query.getResultList().iterator();
        return it.hasNext() ? (Item) it.next() : null;
    }

    public List<Answer> getAnswers()
    {
        Query query = entityManager.createQuery("from com.przemo.entity.Answer");
        return (List<Answer>) query.getResultList();
    }

    public void createEntity(Object entity)
    {
        entityManager.merge(entity);
    }

    @Transactional
    public Item createItem(String name)
    {
        Item item = new Item();
        item.setName(name);
        return entityManager.merge(item);
    }

    @Transactional
    public Question createQuestion(String questionName)
    {
        Question question = new Question();
        question.setQuestion(questionName);
        return entityManager.merge(question);
    }

    @Transactional
    public Answer createAnswer(Question q, Item i, boolean answer)
    {
        Answer a = new Answer();
        a.setAnswer(answer ? "YES" : "NO");
        a.setItem(i);
        a.setQuestionId(q.getId());
        return entityManager.merge(a);
    }
}
