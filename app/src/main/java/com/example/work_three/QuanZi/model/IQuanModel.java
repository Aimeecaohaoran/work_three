package com.example.work_three.QuanZi.model;

import java.util.Map;

public interface IQuanModel {
    void getdianzan(Map path,Map pase,IQuanCallBack iQuanCallBack);
    //定义接口
    interface IQuanCallBack{
        void succ(Object data);
        void onFailed();
    }
    void getqiaodianzan(Map path,Map pase,IQuanQuXiaoCallBack iQuanQuXiaoCallBack);
    //定义接口
    interface IQuanQuXiaoCallBack{
        void succ(Object data);
        void onFailed();
    }
}
