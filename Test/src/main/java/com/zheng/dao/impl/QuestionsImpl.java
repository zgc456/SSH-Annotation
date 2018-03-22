package com.zheng.dao.impl;

import com.zheng.dao.interfice.QuestionsMapper;
import com.zheng.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/3/20.
 */
@Repository
public class QuestionsImpl implements QuestionsMapper {
    @Autowired
   private HibernateTemplate hibernateTemplate;
    @Override
    public void save(Questions questionsEntity) {
        hibernateTemplate.save(questionsEntity);
    }

    @Override
    public List<Questions> selectAll() {
        return (List<Questions>)hibernateTemplate.find("from com.zheng.entity.Questions");
    }
    @Override
    public Questions getById(Integer id) {
        return hibernateTemplate.get(Questions.class,id);
    }
}
