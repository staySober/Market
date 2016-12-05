package com.waitsober.common.pojo;

import java.io.Serializable;

/**
 * Created by Renhai on 2016/12/4.
 */
public class EasyUITreeNode implements Serializable{

    private Long id;
    private String text;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
