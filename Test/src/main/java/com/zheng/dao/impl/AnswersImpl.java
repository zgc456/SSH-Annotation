package com.zheng.dao.impl;

import com.zheng.dao.interfice.AnswersMapper;
import com.zheng.entity.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/3/20.
 */
@Repository
public class AnswersImpl implements AnswersMapper  {
   @Autowired
  private HibernateTemplate hibernateTemplate;
    @Override
    public void save(Answers answersEntity) {
        hibernateTemplate.save(answersEntity);
    }
}
