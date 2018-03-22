package com.zheng.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by lenovo on 2018/3/20.
 */

public class Questions {


    private int id;

    private String title;

    private String ctailDate;

    private int answercount;

    private Date lastModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCtailDate() {
        return ctailDate;
    }

    public void setCtailDate(String ctailDate) {
        this.ctailDate = ctailDate;
    }

    public int getAnswercount() {
        return answercount;
    }

    public void setAnswercount(int answercount) {
        this.answercount = answercount;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }


}
