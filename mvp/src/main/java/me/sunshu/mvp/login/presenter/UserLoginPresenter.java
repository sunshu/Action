package me.sunshu.mvp.login.presenter;

import android.os.*;
import java.util.logging.LogRecord;

import me.sunshu.mvp.common.ErrorBean;
import me.sunshu.mvp.login.bean.User;
import me.sunshu.mvp.login.biz.IUserBiz;
import me.sunshu.mvp.login.biz.OnLoginListener;
import me.sunshu.mvp.login.biz.UserBiz;
import me.sunshu.mvp.login.view.IUserLoginView;

/**
 * 创建时间：  17-6-6.
 * 编写人： sunshu
 * 功能描述：
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();
    public enum ClearWidget{usernameWidget,passwordWidget}

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    /**
     * 登录功能
     */
    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void onLoginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void onLoginFailed(ErrorBean errorBean) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });


            }
        });
    }

    /**
     * 清除用户输入
     */
    public void clean(Enum widget){
        if ( widget.equals(ClearWidget.usernameWidget)){
            userLoginView.clearUserName();
        }else if( widget.equals(ClearWidget.passwordWidget)){
            userLoginView.clearPassword();
        }


    }
}
