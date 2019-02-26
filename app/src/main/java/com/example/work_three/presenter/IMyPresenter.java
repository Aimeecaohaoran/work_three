package com.example.work_three.presenter;

public interface IMyPresenter {
    void getShowModelView(int page);
    void getBanModelView();
    void getBanLoginView(String phone,String pwd);
    void getQuanModelView(int page,int count);
    void getXiangModelView(String id);
    void getSouModelView(String keyword,int page,int count);
    void getShopModelView(long userId,String sessionId);
}
