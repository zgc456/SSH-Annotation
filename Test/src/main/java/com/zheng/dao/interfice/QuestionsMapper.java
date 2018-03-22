package com.zheng.dao.interfice;

import com.zheng.entity.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/3/20.
 */
@Repository
public interface QuestionsMapper {
    void save(Questions questionsEntity);
    List<Questions> selectAll();
    Questions getById(Integer id);
}
