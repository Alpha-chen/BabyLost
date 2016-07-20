package com.click.babylost.presenterImp;

import com.click.babylost.Contract.LoginContract;
import com.click.babylost.retrifitRequest.GitHubApiData;
import com.click.babylost.model.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xpg-click on 2016/7/19.
 */

public class LoginPresenter implements LoginContract.ILoginPresenter {

    private LoginContract.ILoginView  iLoginView;

    public LoginPresenter(LoginContract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void login(String person) {
        iLoginView.showLogining();
        Call<Person> call = GitHubApiData.loginService.listRepos("Alpha-chen");
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                iLoginView.showSuccess(response.body());
            }
            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                iLoginView.showErrorMsg(t.toString());
            }
        });
    }
}
