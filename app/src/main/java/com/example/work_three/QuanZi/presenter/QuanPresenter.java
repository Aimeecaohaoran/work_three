package com.example.work_three.QuanZi.presenter;


import com.example.work_three.QuanZi.model.IQuanModel;
import com.example.work_three.QuanZi.model.QuanModel;
import com.example.work_three.RegActivity;
import com.example.work_three.fragment.TwoFragment;

import java.util.Map;

public class QuanPresenter implements IQuanPresenter {
    TwoFragment twoFragment;
    private final QuanModel registModel;

    public QuanPresenter(TwoFragment twoFragment) {
        this.twoFragment = twoFragment;
        registModel = new QuanModel();
    }

    @Override
    public void getmodeldianzan(Map path, Map pase) {
        registModel.getdianzan(path, pase, new IQuanModel.IQuanCallBack() {
            @Override
            public void succ(Object data) {
                twoFragment.getDianzanView(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }

    @Override
    public void getmodelquxiaodianzan(Map path, Map pase) {
        registModel.getqiaodianzan(path, pase, new IQuanModel.IQuanQuXiaoCallBack() {
            @Override
            public void succ(Object data) {
                twoFragment.getQuxiaoDianzanView(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }
}