package com.example.work_three.liebiao.presenter;


import com.example.work_three.RegActivity;
import com.example.work_three.SouActivity;
import com.example.work_three.fragment.OneFragment;
import com.example.work_three.liebiao.model.IlieModel;
import com.example.work_three.liebiao.model.LieModel;

public class LiePresenter implements ILiePresenter {
    OneFragment oneFragment;
    private final LieModel lieModel;


    public LiePresenter(OneFragment oneFragment) {
        this.oneFragment = oneFragment;
        lieModel = new LieModel();
    }

    @Override
    public void getYiPre() {
        lieModel.getyidata(new IlieModel.ModelYiCallBack() {
            @Override
            public void succ(Object data) {
                oneFragment.LieYiView(data);
            }

            @Override
            public void onFailed() {

            }
        });

    }

    @Override
    public void getErPre(String firstCategoryId) {
        lieModel.geterdata(firstCategoryId, new IlieModel.ModelErCallBack() {
            @Override
            public void succ(Object data) {
                oneFragment.LieErView(data);
            }

            @Override
            public void onFailed() {

            }
        });

    }

    @Override
    public void getErShopPre(String categoryId,int page,int cout) {
        lieModel.getershopdata(categoryId, new IlieModel.ModelErShopCallBack() {
            @Override
            public void succ(Object data) {
                oneFragment.LieErShopView(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }

}