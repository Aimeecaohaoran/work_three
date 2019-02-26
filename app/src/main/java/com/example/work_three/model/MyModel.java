package com.example.work_three.model;

import com.example.work_three.api.UserApiService;
import com.example.work_three.bean.FindShop;
import com.example.work_three.bean.HomeBean;
import com.example.work_three.bean.LoginBean;
import com.example.work_three.bean.NewsBeanTwo;
import com.example.work_three.bean.QuanBean;
import com.example.work_three.bean.ShopBean;
import com.example.work_three.bean.SouBean;
import com.example.work_three.bean.XqBean;
import com.example.work_three.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MyModel implements IModel {

    @Override
    public void getDate(final ModelCallBack callBack) {
        UserApiService userApiService = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService.getcommodity(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<HomeBean>() {
                    @Override
                    public void onNext(HomeBean value) {
                        callBack.onSuccess(value);
                        System.out.println("数据"+value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e);


                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getBanDate(final ModelBanCallBack modelBanCallBack) {
        UserApiService userApiService1 = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService1.getBanner().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<NewsBeanTwo>() {
                    @Override
                    public void onNext(NewsBeanTwo value) {
                    modelBanCallBack.onSuccess(value);
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
    public void getLoginDate(String phone, String pwd, final ModelLoginCallBack modelLoginCallBack) {
        UserApiService userApiService2 = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService2.getLogin(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean value) {
                        modelLoginCallBack.onSuccess(value);
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
    public void getQuanDate(int page,int count ,final ModelQuanCallBack modelQuanCallBack) {
        UserApiService userApiService3 = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService3.getQuan(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<QuanBean>() {
                    @Override
                    public void onNext(QuanBean value) {
                        modelQuanCallBack.onSuccess(value);
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
    public void getQingDate(String id, final ModelQingCallBack modelQingCallBack) {
        UserApiService userApiService3 = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService3.getXiang(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<XqBean>() {
                    @Override
                    public void onNext(XqBean value) {
                        modelQingCallBack.onSuccess(value);
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
    public void getSouDate(String keyword, int page, int count, final ModelSouCallBack modelSouCallBack) {
        UserApiService userApiService4 = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService4.getSou(keyword,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<SouBean>() {
                    @Override
                    public void onNext(SouBean value) {
                        modelSouCallBack.onSuccess(value);
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
    public void getfindShopDate(long userId, String sessionId, final ModelShopCallBack modelShopCallBack) {
        UserApiService userApiService4 = RetrofitUtils.getInstance().create(UserApiService.class);
        userApiService4.getShop(userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<FindShop>() {
                    @Override
                    public void onNext(FindShop value) {
                        modelShopCallBack.onSuccess(value);
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
