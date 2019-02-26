package com.example.work_three.fragment;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.work_three.R;
import com.example.work_three.ShowActivity;
import com.example.work_three.SouActivity;
import com.example.work_three.XiangActivity;
import com.example.work_three.adapter.ByIdAdapter;
import com.example.work_three.adapter.ErJiAdapter;
import com.example.work_three.adapter.MySouAdapter;
import com.example.work_three.adapter.MyXinAdapter;
import com.example.work_three.adapter.TopHomeAdapter;
import com.example.work_three.bean.ByIdBean;
import com.example.work_three.bean.ErJi;
import com.example.work_three.bean.EventBusBean;
import com.example.work_three.bean.HomeBean;
import com.example.work_three.bean.KeyBean;
import com.example.work_three.bean.Message;
import com.example.work_three.bean.NewsBeanTwo;
import com.example.work_three.bean.ShopKeyBean;
import com.example.work_three.bean.SouBean;
import com.example.work_three.bean.TopLasBean;
import com.example.work_three.bean.XqBean;
import com.example.work_three.liebiao.presenter.LiePresenter;
import com.example.work_three.liebiao.view.LieView;
import com.example.work_three.presenter.MyPresenter;
import com.example.work_three.view.IView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OneFragment extends Fragment  implements IView,LieView {
    @BindView(R.id.shouye_recy)
    XRecyclerView shouye_recy;
    @BindView(R.id.left_recy)
    XRecyclerView left_recy;
    @BindView(R.id.sou)
    EditText sou;
    @BindView(R.id.btn_sou)
    ImageView btn_sou;
    @BindView(R.id.left_top)
    ImageView left_top;
    private String name;
    private MyPresenter myPresenter;
    private int page=1;
    private MyXinAdapter myXinAdapter;
    private NewsBeanTwo newsBeanTwo;
    private HomeBean homeBean;
    private int count=5;
    private String keyword;
    private TopHomeAdapter adapter;
    private ErJiAdapter adapters;
    private PopupWindow popupWindow;
    private LiePresenter liePresenter;
    private String firstCategoryId;
    private TopLasBean topLasBean;
    private ErJi erJi;
    private RecyclerView topView;
    private RecyclerView popup_two;
    private String categoryId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment, container, false);
        //绑定presenter
        EventBus.getDefault().register(this);
        //绑定黄油刀
        ButterKnife.bind(this,view);
        //绑定presenter
        liePresenter = new LiePresenter(this);
        myPresenter = new MyPresenter(this);
        myPresenter.getShowModelView(page);
        myPresenter.getBanModelView();
        btn_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = sou.getText().toString();
                KeyBean keyBean = new KeyBean(keyword);
                EventBus.getDefault().postSticky(keyBean);
                startActivity(new Intent(getActivity(),SouActivity.class));
                EventBus.getDefault().post(keyword);

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        shouye_recy.setLayoutManager(linearLayoutManager);

        //刷新加载
        shouye_recy.setPullRefreshEnabled(true);
        shouye_recy.setLoadingMoreEnabled(true);
        shouye_recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        page=1;
                        myPresenter.getShowModelView(page);
                        shouye_recy.refreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        page++;
                        myPresenter.getShowModelView(page);
                        shouye_recy.loadMoreComplete();
                        myXinAdapter.notifyDataSetChanged();
                        Toast.makeText(getActivity(),"没有更多数据",Toast.LENGTH_SHORT).show();

                    }
                },2000);
            }
        });
        //popwidown
        left_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDatas();
            }
        });

        return view;
    }
    @Override
    public void getShowData(Object obj) {
        if (obj!=null){
            homeBean= (HomeBean) obj;
            name = homeBean.getResult().getMlss().get(0).getName();
            myXinAdapter = new MyXinAdapter(getActivity(),homeBean,newsBeanTwo);
            shouye_recy.setAdapter(myXinAdapter);
        }

    }

    @Override
    public void getBanData(Object obj) {
        if (obj!=null){
            newsBeanTwo= (NewsBeanTwo) obj;
            myXinAdapter = new MyXinAdapter(getActivity(),homeBean,newsBeanTwo);
            shouye_recy.setAdapter(myXinAdapter);

        }

    }

    @Override
    public void getLoginData(Object obj) {

    }

    @Override
    public void getQuanData(Object obj) {

    }

    @Override
    public void getXiangData(Object obj) {
        XqBean xqBean= (XqBean) obj;
        EventBus.getDefault().postSticky(xqBean.getResult().getDetails());
    }

    @Override
    public void getSouData(Object obj) {

    }

    @Override
    public void getShopData(Object obj) {

    }
    //pop
    private void initDatas() {
        View v = View.inflate(getActivity(), R.layout.popup, null);
        topView = v.findViewById(R.id.recycle_top);

        topView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        popup_two = v.findViewById(R.id.popup_two);
        loadData();

        popup_two.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        popupWindow = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(v, Gravity.CENTER_VERTICAL, 0, -500);


    }

    private void loadData() {
        liePresenter.getYiPre();
    }


    @Override
    public void LieYiView(Object obj) {
if (obj!=null){
    topLasBean= (TopLasBean) obj;
    List<TopLasBean.ResultBean> mList = topLasBean.getResult();
    adapter = new TopHomeAdapter(getActivity(),mList);
    topView.setAdapter(adapter);
    adapter.result(new TopHomeAdapter.Cicklistener() {
        @Override
        public void setonclicklisener(int index) {
            String id = topLasBean.getResult().get(index).getId();
            firstCategoryId=id;
            liePresenter.getErPre(id);

        }
    });
}

    }

    @Override
    public void LieErView(Object obj) {
       erJi= (ErJi) obj;
        List<ErJi.ResultBean> result = erJi.getResult();
        adapters = new ErJiAdapter(getActivity(),result);
        popup_two.setAdapter(adapters);

    }

    @Override
    public void LieErShopView(Object obj) {
        shouye_recy.setVisibility(View.GONE);
        left_recy.setVisibility(View.VISIBLE);
        if (obj!=null) {
            ByIdBean byIdBean = (ByIdBean) obj;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
            gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            left_recy.setLayoutManager(gridLayoutManager);
            ByIdAdapter byIdAdapter = new ByIdAdapter(getActivity(), byIdBean);
            left_recy.setAdapter(byIdAdapter);
        }
    }
    //取消订阅,销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    //注解
 @Subscribe(threadMode = ThreadMode.MAIN)
 public void shou(Message message){
   String str=message.getMsg();
     System.out.println("传递消息"+str);
     liePresenter.getErShopPre(str,1,5);
 }


}

