package com.click.babylost.Contract;

/**
 * 登录契约类
 * Created by xpg-click on 2016/7/19.
 */
public class LoginContract {

     public interface ILoginView{
         public void showLogining();

         public void showSuccess(Object object);

         public void showErrorMsg(String errorMsg);

     }

     public interface ILoginPresenter{

         public void login (String  url);

     }

}
