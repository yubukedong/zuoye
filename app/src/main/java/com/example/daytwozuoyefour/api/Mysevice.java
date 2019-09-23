package com.example.daytwozuoyefour.api;

import com.example.daytwozuoyefour.bean.Beanone;
import com.example.daytwozuoyefour.bean.Beantwo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Mysevice {
    String s="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/content/getData/30/66597/1/10")
//    @POST("")
    Observable<Beanone> getData();

    String xiang="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/teacher/getTeacherPower/2")
    Observable<Beantwo> getDatas();
}
