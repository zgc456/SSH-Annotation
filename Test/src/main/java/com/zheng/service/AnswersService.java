package com.zheng.service;

import com.zheng.dao.impl.AnswersImpl;
import com.zheng.entity.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lenovo on 2018/3/20.
 */
@Service
@Transactional(readOnly = false)
public class AnswersService {
    @Autowired
    private AnswersImpl answersMapper;
   public void save(Answers answersEntity){
       System.out.println(answersMapper);
    answersMapper.save(answersEntity);
    }
}
