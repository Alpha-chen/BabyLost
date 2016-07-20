package com.click.babylost.retrofitnet;

import com.click.babylost.model.Person;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by xpg-click on 2016/7/20.
 */
public interface LoginService {
    @GET("/users/{user}")
    Call<Person> listRepos(@Path("user") String user);
}
