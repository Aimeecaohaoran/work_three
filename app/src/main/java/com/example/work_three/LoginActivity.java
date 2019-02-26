package com.example.work_three;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.work_three.app.Myapp;
import com.example.work_three.bean.HomeBean;
import com.example.work_three.bean.LoginBean;
import com.example.work_three.bean.UserEntity;
import com.example.work_three.greendao.DaoMaster;
import com.example.work_three.greendao.DaoSession;
import com.example.work_three.greendao.UserEntityDao;
import com.example.work_three.presenter.MyPresenter;
import com.example.work_three.utils.GreendaoUtils;
import com.example.work_three.utils.SharedPreferencesUtil;
import com.example.work_three.utils.SqliteUtils;
import com.example.work_three.view.IView;
import com.zhy.autolayout.AutoLayoutActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AutoLayoutActivity implements IView {

    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @BindView(R.id.ck_rem_pwd)
    CheckBox ckRemPwd;
    @BindView(R.id.text_reg)
    TextView textReg;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.login_eye_check)
    ImageView eyes;

    private MyPresenter myPresenter;
    private Unbinder bind;
    private SharedPreferences sharedPreferences;
    private List<UserEntity> list;
    private UserEntityDao userEntityDao;
    private OkHttpClient.Builder builder;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myPresenter = new MyPresenter(this);
        bind = ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences("UserS", MODE_PRIVATE);
        edit =sharedPreferences.edit();
        etLoginName.setText(SharedPreferencesUtil.getString("phone",null));
        if (SharedPreferencesUtil.getBoolean("flag",false)){
            etLoginPwd.setText(SharedPreferencesUtil.getString("pwd",null));
            ckRemPwd.setChecked(SharedPreferencesUtil.getBoolean("flag",false));
        }else {
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etLoginName.getText().toString();
                String pwd = etLoginPwd.getText().toString();
                if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                } else
                {
                    myPresenter.getBanLoginView(phone,pwd);
                    if (ckRemPwd.isChecked()){
                        SharedPreferencesUtil.put("phone",etLoginName.getText().toString());
                        SharedPreferencesUtil.put("pwd",etLoginPwd.getText().toString());
                        SharedPreferencesUtil.put("flag",ckRemPwd.isChecked());
                    }else {
                        SharedPreferencesUtil.remove("pwd");
                        SharedPreferencesUtil.remove("phone");
                    }

                }


            }
        });
       textReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });
       eyes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (etLoginPwd.getInputType() == 129) {
                   etLoginPwd.setInputType(128);
               } else {
                   etLoginPwd.setInputType(129);
               }
           }
       });
    }

    @Override
    public void getShowData(Object obj) {

    }

    @Override
    public void getBanData(Object obj) {

    }

    @Override
    public void getLoginData(Object obj) {
        LoginBean loginBean= (LoginBean) obj;
        String status = loginBean.getStatus();
        if (status.equals("0000")) {
            Toast.makeText(LoginActivity.this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            edit.putString("userId",loginBean.getResult().getUserId());
            edit.putString("sessionId",loginBean.getResult().getSessionId());
            edit.putString("pwd",etLoginPwd.getText().toString());
            edit.commit();
            startActivity(new Intent(LoginActivity.this,ShowActivity.class));
            finish();
        } else {
            Toast.makeText(LoginActivity.this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void getQuanData(Object obj) {

    }

    @Override
    public void getXiangData(Object obj) {

    }

    @Override
    public void getSouData(Object obj) {

    }

    @Override
    public void getShopData(Object obj) {

    }
   /* @OnClick(R.id.img_login)
    public void onViewClicked() {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }*/
}
