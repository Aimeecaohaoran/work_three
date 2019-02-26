package com.example.work_three.presenter;

import android.util.Log;

import com.example.work_three.LoginActivity;
import com.example.work_three.SouActivity;
import com.example.work_three.XiangActivity;
import com.example.work_three.fragment.OneFragment;
import com.example.work_three.fragment.ThreeFragment;
import com.example.work_three.fragment.TwoFragment;
import com.example.work_three.model.IModel;
import com.example.work_three.model.MyModel;

public class MyPresenter implements IMyPresenter {
    OneFragment oneFragment;
    LoginActivity loginActivity;
    private final MyModel myModel;
    TwoFragment twoFragment;
    XiangActivity xiangActivity;
    SouActivity souActivity;
    //CustomXiangQingActivity customXiangQingActivity;
    ThreeFragment threeFragment;

    public MyPresenter(ThreeFragment threeFragment) {
        this.threeFragment = threeFragment;
        myModel = new MyModel();
    }
/*
    public MyPresenter(CustomXiangQingActivity customXiangQingActivity) {
        this.customXiangQingActivity = customXiangQingActivity;
        myModel = new MyModel();
    }*/

    public MyPresenter(SouActivity souActivity) {
        this.souActivity = souActivity;
        myModel = new MyModel();
    }

    public MyPresenter(XiangActivity xiangActivity) {
        this.xiangActivity = xiangActivity;
        myModel = new MyModel();
    }

    public MyPresenter(TwoFragment twoFragment) {
        this.twoFragment = twoFragment;
        myModel = new MyModel();
    }

    public MyPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        myModel = new MyModel();
    }

    public MyPresenter(OneFragment oneFragment) {
        this.oneFragment = oneFragment;
        myModel = new MyModel();
    }

    @Override
    public void getShowModelView(int page) {
        myModel.getDate(new IModel.ModelCallBack() {
            @Override
            public void onSuccess(Object obj) {
                oneFragment.getShowData(obj);
            }

            @Override
            public void onFail(Throwable e) {

            }
        });
    }

    @Override
    public void getBanModelView() {
    myModel.getBanDate(new IModel.ModelBanCallBack() {
        @Override
        public void onSuccess(Object obj) {
            oneFragment.getBanData(obj);
        }

        @Override
        public void onFail(Throwable e) {

        }
    });
    }

    @Override
    public void getBanLoginView(String phone, String pwd) {
        myModel.getLoginDate(phone, pwd, new IModel.ModelLoginCallBack() {
            @Override
            public void onSuccess(Object obj) {
                loginActivity.getLoginData(obj);
                Log.i( "onSuccess: ",obj.toString());
            }

            @Override
            public void onFail(Throwable e) {

            }
        });
    }

    @Override
    public void getQuanModelView(int page, int count) {
       myModel.getQuanDate(page, count, new IModel.ModelQuanCallBack() {
           @Override
           public void onSuccess(Object obj) {
               twoFragment.getQuanData(obj);
           }

           @Override
           public void onFail(Throwable e) {

           }
       });

    }

    @Override
    public void getXiangModelView(String id) {
        myModel.getQingDate(id, new IModel.ModelQingCallBack() {
            @Override
            public void onSuccess(Object obj) {
                xiangActivity.getXiangData(obj);
            }

            @Override
            public void onFail(Throwable e) {

            }
        });
    }

    @Override
    public void getSouModelView(String keyword, int page, int count) {
     myModel.getSouDate(keyword, page, count, new IModel.ModelSouCallBack() {
         @Override
         public void onSuccess(Object obj) {
             souActivity.getSouData(obj);
         }

         @Override
         public void onFail(Throwable e) {

         }
     });
    }

    @Override
    public void getShopModelView(long userId, String sessionId) {
      myModel.getfindShopDate(userId, sessionId, new IModel.ModelShopCallBack() {
          @Override
          public void onSuccess(Object obj) {
              threeFragment.getShopData(obj);
          }

          @Override
          public void onFail(Throwable e) {

          }
      });

    }

    public void getBanModelView(int page) {
    }
}
