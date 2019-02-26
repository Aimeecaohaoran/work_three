package com.example.work_three;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.work_three.adapter.MyXinAdapter;
import com.example.work_three.bean.HomeBean;
import com.example.work_three.bean.NewsBeanTwo;
import com.example.work_three.fragment.FiveFragment;
import com.example.work_three.fragment.FourFragment;
import com.example.work_three.fragment.OneFragment;
import com.example.work_three.fragment.ThreeFragment;
import com.example.work_three.fragment.TwoFragment;
import com.example.work_three.presenter.MyPresenter;
import com.example.work_three.view.IView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity  {
    private BottomTabBar fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        fragment = findViewById(R.id.fragment);
        fragment.init(getSupportFragmentManager())
                .setImgSize(80,80)
                .setFontSize(0)
                .setTabPadding(80,6,0)
                .addTabItem("",R.drawable.home_s,R.drawable.home_n,OneFragment.class)
                .addTabItem("",R.drawable.circle_s,R.drawable.circle_n,TwoFragment.class)
                .setTabPadding(30,6,0)
                .setImgSize(120,120)
                .addTabItem("",R.drawable.gou_two,R.drawable.gou_two,ThreeFragment.class)
                .setImgSize(80,80)
                .setTabPadding(80,6,0)
                .addTabItem("",R.drawable.list_s,R.drawable.list_n,FourFragment.class)
                .addTabItem("",R.drawable.mine_s,R.drawable.mine_n,FiveFragment.class)
                .isShowDivider(false);
    }
}
