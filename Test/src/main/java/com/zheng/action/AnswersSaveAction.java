package com.zheng.action;

import com.opensymphony.xwork2.Action;
import com.zheng.entity.Answers;
import com.zheng.service.AnswersService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.sql.Date;

/**
 * Created by lenovo on 2018/3/20.
 */
@Scope("prototype")
@ParentPackage("struts-default")  //表示继承的父包
@Namespace(value = "/") //命名空间
public class AnswersSaveAction implements Action {
    @Autowired(required = false)
    AnswersService answersService;

   @org.apache.struts2.convention.annotation.Action(value = "answersSave", results = {@Result(name = "success", location = "/index.jsp")})
    @Override
    public String execute() throws Exception {
        System.out.println(answersService);
        Answers answersEntity=new Answers();
        answersEntity.setAnsContent("1");
        answersEntity.setAnsDate(new Date(2017,7,2));
        answersEntity.setQid(1);
        answersService.save(answersEntity);
        return Action.SUCCESS;
    }
}
