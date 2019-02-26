package com.example.work_three.QuanZi.model;



import com.example.work_three.api.UserApiService;
import com.example.work_three.bean.RegBean;
import com.example.work_three.regist.model.IRegistModel;
import com.example.work_three.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class QuanModel implements IQuanModel {

    @Override
    public void getdianzan(Map path, Map pase, final IQuanCallBack iQuanCallBack) {
       UserApiService userApiService = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService.getDian(path,pase)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<RegBean>() {
                    @Override
                    public void onNext(RegBean value) {
                        iQuanCallBack.succ(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getqiaodianzan(Map path, Map pase, final IQuanQuXiaoCallBack iQuanQuXiaoCallBack) {
        UserApiService userApiService1 = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService1.getXiaoDian(path,pase)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<RegBean>() {
                    @Override
                    public void onNext(RegBean value) {
                        iQuanQuXiaoCallBack.succ(value);
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
