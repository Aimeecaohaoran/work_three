package com.example.work_three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.work_three.bean.RegBean;
import com.example.work_three.regist.model.RegistModel;
import com.example.work_three.regist.presenter.RegistPresenter;
import com.example.work_three.regist.view.IRegistView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegActivity extends AppCompatActivity implements IRegistView {
    @BindView(R.id.et_reg_name)
    EditText etRegName;
    @BindView(R.id.et_reg_yan)
    EditText etRegYan;
    @BindView(R.id.et_reg_pwd)
    EditText etRegPwd;
    @BindView(R.id.text_login)
    TextView textLogin;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    private Unbinder bind;
    private RegistPresenter registPresenter;
    private String phone,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        bind = ButterKnife.bind(RegActivity.this);
        registPresenter = new RegistPresenter(this);
        btnRegist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                phone = etRegName.getText().toString();
                pwd = etRegPwd.getText().toString();
                if(phone !=""|| pwd !=""){
                    registPresenter.registPre(phone,pwd);
                }else{
                    Toast.makeText(RegActivity.this,"账号密码不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showMsg(Object obj) {
        RegBean regBean= (RegBean) obj;
        Toast.makeText(RegActivity.this,regBean.getMessage(),Toast.LENGTH_SHORT).show();
        if (!regBean.getMessage().equals("该手机号已注册，不能重复注册!")){
            startActivity(new Intent(RegActivity.this,ShowActivity.class));
        }

    }
}
