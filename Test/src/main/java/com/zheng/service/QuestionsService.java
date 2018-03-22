package com.zheng.service;

import com.zheng.dao.impl.QuestionsImpl;
import com.zheng.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2018/3/20.
 */
@Service
@Transactional(readOnly = false)
public class QuestionsService {
    @Autowired
   private QuestionsImpl questionsMapper;
    void save(Questions questionsEntity){
        questionsMapper.save(questionsEntity);
    }
    List<Questions> selectAll(){
         return questionsMapper.selectAll();
    }
    Questions getById(Integer id){
        return questionsMapper.getById(id);
    }
}
