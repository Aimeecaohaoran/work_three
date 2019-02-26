package com.example.work_three.regist.presenter;


import com.example.work_three.RegActivity;
import com.example.work_three.regist.model.IRegistModel;
import com.example.work_three.regist.model.RegistModel;

public class RegistPresenter implements IRegistPresenter{
    RegActivity regActivity;
    private final RegistModel registModel;

    public RegistPresenter(RegActivity regActivity) {
        this.regActivity = regActivity;
        registModel = new RegistModel();
    }



    @Override
    public void registPre(String phone, String pwd) {
        registModel.regist(phone, pwd, new IRegistModel.IRegistCallBack() {
            @Override
            public void onStatus(Object data) {
                regActivity.showMsg(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }
}