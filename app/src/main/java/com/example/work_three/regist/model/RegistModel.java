package com.example.work_three.regist.model;



import com.example.work_three.api.UserApiService;
import com.example.work_three.bean.LoginBean;
import com.example.work_three.bean.RegBean;
import com.example.work_three.utils.RetrofitUtils;

import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class RegistModel implements IRegistModel{
    private UserApiService userApiService;

    @Override
    public void regist(String phone, String pwd, final IRegistCallBack callBack) {
        userApiService = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService.getReg(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<RegBean>() {
                    @Override
                    public void onNext(RegBean value) {
                        callBack.onStatus(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
