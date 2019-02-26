package com.example.work_three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.work_three.bean.EventBusBean;
import com.example.work_three.bean.XqBean;
import com.example.work_three.presenter.MyPresenter;
import com.example.work_three.view.IView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class XiangActivity extends AppCompatActivity implements IView{

    private WebView webView;
    private MyPresenter myPresenter;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        webView = findViewById(R.id.web_view);
        //注册方法
        EventBus.getDefault().register(this);
        myPresenter = new MyPresenter(this);
        myPresenter.getXiangModelView(id);
    }
    //取消订阅,销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    //接收订阅 ,,参数是bean
    @Subscribe(sticky=true)
    public void event(EventBusBean eventBusBean){
        id = eventBusBean.getId();
    }

    @Override
    public void getShowData(Object obj) {

    }

    @Override
    public void getBanData(Object obj) {

    }

    @Override
    public void getLoginData(Object obj) {

    }

    @Override
    public void getQuanData(Object obj) {

    }

    @Override
    public void getXiangData(Object obj) {
        XqBean xqBean= (XqBean) obj;
        String details = xqBean.getResult().getDetails();
        webView.loadDataWithBaseURL(null,details,"text/html","UTF-8",null);
    }

    @Override
    public void getSouData(Object obj) {

    }

    @Override
    public void getShopData(Object obj) {

    }
}
