package com.example.work_three;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;

import com.example.work_three.adapter.MySouAdapter;
import com.example.work_three.bean.EventBusBean;
import com.example.work_three.bean.KeyBean;
import com.example.work_three.bean.SouBean;
import com.example.work_three.liebiao.presenter.LiePresenter;
import com.example.work_three.liebiao.view.LieView;
import com.example.work_three.presenter.MyPresenter;
import com.example.work_three.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SouActivity extends AppCompatActivity implements IView {
    private XRecyclerView sou_recy;
    private MyPresenter myPresenter;
    private String keyword;
    private LiePresenter liePresenter;
    private String categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou);
        sou_recy=findViewById(R.id.sou_recy);
        //绑定presenter
        EventBus.getDefault().register(this);
        myPresenter = new MyPresenter(this);
        myPresenter.getSouModelView(keyword,1,5);
    }
    //取消订阅,销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    //接收订阅 ,,参数是bean
    @Subscribe(sticky=true)
    public void event(KeyBean keyBean){
        keyword = keyBean.getKeyword();
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

    }

    @Override
    public void getSouData(Object obj) {
        SouBean souBean= (SouBean) obj;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(SouActivity.this,2);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        sou_recy.setLayoutManager(gridLayoutManager);
        MySouAdapter mySouAdapter = new MySouAdapter(SouActivity.this, souBean);
        sou_recy.setAdapter(mySouAdapter);


    }

    @Override
    public void getShopData(Object obj) {

    }


}
