package com.example.work_three.bean;

import java.io.Serializable;

public class KeyBean implements Serializable {
    private String keyword;

    public KeyBean(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
