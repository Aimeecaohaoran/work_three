package com.example.work_three.api;

import com.example.work_three.bean.AllOrder;
import com.example.work_three.bean.ByIdBean;
import com.example.work_three.bean.ErJi;
import com.example.work_three.bean.FindShop;
import com.example.work_three.bean.HomeBean;
import com.example.work_three.bean.LoginBean;
import com.example.work_three.bean.NewsBeanTwo;
import com.example.work_three.bean.QuanBean;
import com.example.work_three.bean.RegBean;
import com.example.work_three.bean.ShopBean;
import com.example.work_three.bean.SouBean;
import com.example.work_three.bean.TopLasBean;
import com.example.work_three.bean.XqBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApiService {

    //首页
    @GET(ApiService.SHOP_LIE)
    Observable<HomeBean> getcommodity(@Query("page") int page);
    //XBanner
    @GET(ApiService.BANNER)
    Observable<NewsBeanTwo> getBanner();
    //登录
    @POST(ApiService.LOGIN)
    @FormUrlEncoded
    Observable<LoginBean> getLogin(@Field("phone") String phone, @Field("pwd") String pwd);
    //注册
    @POST(ApiService.REG_URL)
    @FormUrlEncoded
    Observable<RegBean> getReg(@Field("phone") String phone, @Field("pwd") String pwd);
    //圈子
    @GET(ApiService.SHOP_CIRCLE)
    Observable<QuanBean> getQuan(@Query("page") int page, @Query("count") int count);
    //商品详情
    @GET(ApiService.XIANG)
    Observable<XqBean> getXiang(@Query("commodityId") String commodityId);
    //首页搜索
    @GET(ApiService.SOUSUO)
    Observable<SouBean> getSou(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);
    //商品一级列表
    @GET(ApiService.YIJI)
    Observable<TopLasBean> getyiji();
    //商品二级列表
    @GET(ApiService.ERJI)
    Observable<ErJi> geterji(@Query("firstCategoryId") String firstCategoryId);
    //二级列表的商品
    @GET(ApiService.ERSHOP)
    Observable<ByIdBean> geterjishop(@Query("categoryId") String categoryId, @Query("page") int page, @Query("count") int count);
   //点赞
    @POST(ApiService.DIANZAN)
    @FormUrlEncoded
    Observable<RegBean> getDian(@HeaderMap Map<String,String> path, @FieldMap Map<String,String> pase );
    //点赞
    @POST(ApiService.QUXIAODIANZAN)
    @FormUrlEncoded
    Observable<RegBean> getXiaoDian(@HeaderMap Map<String,String> path, @FieldMap Map<String,String> pase );



    /**
     * 购物车数据
     * @return
     */
    @GET("order/verify/v1/findShoppingCart")
    Observable<FindShop> getShop(@Header("userId")long userId, @Header("sessionId")String sessionId);


    /**
     * 订单数据
     * @return
     */
    @GET("order/verify/v1/findOrderListByStatus")
    Observable<AllOrder> getallorder(@Header("userId")long userId,
                                     @Header("sessionId")String sessionId,
                                     @Query("status") int status,
                                     @Query("page")int page,
                                     @Query("count")int count);

}
