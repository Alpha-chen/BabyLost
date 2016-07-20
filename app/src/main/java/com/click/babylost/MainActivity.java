package com.click.babylost;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.click.babylost.Contract.LoginContract.ILoginView;
import com.click.babylost.model.Person;
import com.click.babylost.presenterImp.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ILoginView {
    @BindView(R.id.login_user_name_et)
    EditText loginUserNameEt;
    @BindView(R.id.login_password_et)
    EditText loginPasswordEt;
    @BindView(R.id.login_user_name)
    TextView loginUserName;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.git_response)
    TextView git_response;
    private LoginPresenter loginPresenter;

    private String userName="";
    private String password="";

    private Person person;
    private boolean isLogining=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
//        loginPresenter.login(userName);

    }

    @Override
    public void showLogining() {
        isLogining =false;
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSuccess(Object o) {
        isLogining = true;
        progressBar.setVisibility(View.GONE);
        git_response.setVisibility(View.VISIBLE);
        git_response.setText(o.toString());
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        isLogining = true;
        progressBar.setVisibility(View.GONE);
        git_response.setVisibility(View.VISIBLE);
        git_response.setTextColor(Color.RED);
        git_response.setText(errorMsg);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (isLogining){
//            return true;
//        }else {
//            return false;
//        }
//    }

    @OnClick(R.id.login_button)
    public void onClick() {
        Log.d("MainActivity","55");
        checkInput();
    }

    public boolean checkInput(){
        userName= loginUserNameEt.getText().toString();
        password = loginPasswordEt.getText().toString();
        if (TextUtils.isEmpty(userName)|| TextUtils.isEmpty(password)){
            Toast.makeText(MainActivity.this,"輸入不能為空",Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }
}
