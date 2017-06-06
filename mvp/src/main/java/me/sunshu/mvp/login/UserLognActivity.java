package me.sunshu.mvp.login;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import me.sunshu.mvp.R;
import me.sunshu.mvp.login.bean.User;
import me.sunshu.mvp.login.presenter.UserLoginPresenter;
import me.sunshu.mvp.login.view.IUserLoginView;

public class UserLognActivity extends AppCompatActivity implements IUserLoginView {

    private EditText mEdUserName; // 输入框用户名
    private EditText mEdPassword; // 密码
    private View mBtnLogin;  // 登录
    private ImageView mIvCleanUserName,mIvCleanPassword; // 清除
    private ProgressBar mProgressBar;  // 加载框
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
    private UserLoginPresenter.ClearWidget clearWidget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_logn);
        initViews();

    }

    private void initViews() {
        mEdUserName = (EditText) findViewById(R.id.ed_username);
        mEdPassword = (EditText) findViewById(R.id.ed_password);
        mBtnLogin = findViewById(R.id.btn_login);
        mIvCleanUserName = (ImageView) findViewById(R.id.iv_clean_username);
        mIvCleanPassword = (ImageView) findViewById(R.id.iv_clean_password);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();

            }
        });

        mIvCleanUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clean(clearWidget.usernameWidget);
            }
        });

        mIvCleanPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clean(clearWidget.passwordWidget);
            }
        });

    }

    @Override
    public String getUserName() {
        return mEdUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEdPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEdUserName.setText("");
    }

    @Override
    public void clearPassword() {
        mEdPassword.setText("");
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,user.getUsername()+"登录成功",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }
}
