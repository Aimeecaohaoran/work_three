package com.example.work_three.model;

public interface IModel {
    //加载数据
    void  getDate( ModelCallBack callBack);
    interface  ModelCallBack{
        void  onSuccess(Object obj);
        void  onFail(Throwable e);
    }
    //banner
    void  getBanDate( ModelBanCallBack modelBanCallBack);
    interface  ModelBanCallBack{
        void  onSuccess(Object obj);
        void  onFail(Throwable e);
    }
    //登录
    void  getLoginDate(String phone,String pwd, ModelLoginCallBack modelLoginCallBack);
    interface  ModelLoginCallBack{
        void  onSuccess(Object obj);
        void  onFail(Throwable e);
    }
    //圈子
    void  getQuanDate( int page,int count ,ModelQuanCallBack modelQuanCallBack);
    interface  ModelQuanCallBack{
        void  onSuccess(Object obj);
        void  onFail(Throwable e);
    }
    //详情
    void  getQingDate( String id,ModelQingCallBack modelQingCallBack);
    interface  ModelQingCallBack{
        void  onSuccess(Object obj);
        void  onFail(Throwable e);
    }
    //根据关键词搜索商品
    void  getSouDate(String keyword,int page,int count,ModelSouCallBack modelSouCallBack);
    interface  ModelSouCallBack{
        void  onSuccess(Object obj);
        void  onFail(Throwable e);
    }
    //根据关键词搜索商品
    void  getfindShopDate(long userId,String sessionId,ModelShopCallBack modelShopCallBack);
    interface  ModelShopCallBack{
        void  onSuccess(Object obj);
        void  onFail(Throwable e);
    }


}
