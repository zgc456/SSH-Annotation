package com.zheng.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by lenovo on 2018/3/20.
 */

public class Answers {

    private int id;

    private String ansContent;

    private Date ansDate;

    private int qid;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnsContent() {
        return ansContent;
    }

    public void setAnsContent(String ansContent) {
        this.ansContent = ansContent;
    }

    public Date getAnsDate() {
        return ansDate;
    }

    public void setAnsDate(Date ansDate) {
        this.ansDate = ansDate;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }


}
