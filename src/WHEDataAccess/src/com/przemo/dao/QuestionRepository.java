package com.przemo.dao;

import com.przemo.entity.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>
{
    @Query(name = "countQuestions",
           value = "select count(*) " +
                   "from com.przemo.entity.Question q, com.przemo.entity.Answer a " +
                   "where q.id=a.questionId")
    public Long getQuestionCount();

    @Query(name = "getUnasweredQuestions",
           value = "select t1.question " +
                   "from com.przemo.entity.Answer an " +
                   "right join " +
                        "(select q.id as qid,it.id as iid, q.question as question, it.name as name " +
                         "from com.przemo.entity.Question q, com.przemo.entity.Item it " +
                         "where it.name=:name) t1 " +
                   "on an.questionId=t1.qid and an.itemId=t1.iid " +
                   "where an.answer is null")
    public List<String> getUnansweredQuestions(@Param(value = "name") String name);

    @Query(name = "getQuestionsByDetailLevel",
           value = "select t1.question from (" +
                   "select abs(count(*)-(select count(*)/2 as result from com.przemo.entity.Item)) as sum, q.question as question " +
                   "from com.przemo.entity.Answer an, com.przemo.entity.Question q " +
                   "where an.questionId=q.id and an.answer='YES' " +
                   "group by q.question order by sum asc) t1")
    public List<String> getQuestionsByDetailLevel();

    @Query(name = "getQuestionsByDetailLevelAndItems",
            value = "select t1.question from (" +
                    "select abs(count(*)-:itemsSize/2) as sum, q.question as question " +
                    "from com.przemo.entity.Answer an, com.przemo.entity.Question q, com.przemo.entity.Item it " +
                    "where an.questionId=q.id and an.answer='YES' and it.id=an.itemId and it.name in :items " +
                    "group by q.question order by sum asc) t1")
    public List<String> getQuestionsByDetailLevelAndItems(@Param(value = "items") List<String> items,@Param(value = "itemsSize") Integer itemsSize);

//    value = "select t1.question from (" +
//        "select abs(count(*)-(select count(*)/2 as result from com.przemo.entity.Item)) as sum, q.question " +
//        "from com.przemo.entity.Answer an, com.przemo.entity.Question q " +
//        "where an.questionId=q.id and an.answer='YES' " +
//        "group by q.question order by sum asc) t1")
}
