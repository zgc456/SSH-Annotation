package com.zheng.dao.interfice;

import com.zheng.entity.Answers;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/3/20.
 */
@Repository
public interface AnswersMapper {
    void save(Answers answersEntity);
}
