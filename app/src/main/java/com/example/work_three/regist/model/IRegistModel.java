package com.example.work_three.regist.model;

public interface IRegistModel {
    void regist( String phone, String pwd, IRegistCallBack callBack);
    //定义接口
    interface IRegistCallBack{
        void onStatus(Object data);
        void onFailed();
    }
}
