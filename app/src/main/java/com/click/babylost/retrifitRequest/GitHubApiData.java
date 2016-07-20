package com.click.babylost.retrifitRequest;

import com.click.babylost.retrofitnet.LoginService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 构造具体的请求service
 * Created by xpg-click on 2016/7/20.
 */
public class GitHubApiData {
    static final String gitUrl = "https://api.github.com";

    static Retrofit retrofit = new Retrofit.Builder().baseUrl(gitUrl).addConverterFactory(GsonConverterFactory.create()).build();

    public static LoginService loginService = retrofit.create(LoginService.class);

}
