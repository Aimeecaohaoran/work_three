package com.example.work_three.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.work_three.R;
import com.example.work_three.adapter.MyShopAdapter;
import com.example.work_three.bean.FindShop;
import com.example.work_three.bean.ShopBean;
import com.example.work_three.presenter.MyPresenter;
import com.example.work_three.view.IView;


public class ThreeFragment extends Fragment implements IView {
    private MyPresenter myPresenter;
    private RecyclerView shop_recy;
    private MyShopAdapter myShopAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.three_fragment, container, false);
        shop_recy = view.findViewById(R.id.shop_recy);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        shop_recy.setLayoutManager(gridLayoutManager);
        shop_recy.setAdapter(myShopAdapter);


        myPresenter = new MyPresenter(this);
        myPresenter.getShopModelView(292,"1550826750960292");

        return view;
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

    }

    @Override
    public void getShopData(Object obj) {
        FindShop findShop= (FindShop) obj;
        myShopAdapter = new MyShopAdapter(getActivity(), findShop);
        myShopAdapter.notifyDataSetChanged();




    }
}
