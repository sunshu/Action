package me.sunshu.mvp.login.view;

import me.sunshu.mvp.login.bean.User;

/**
 * 创建时间：  17-6-4.
 * 编写人： sunshu
 * 功能描述：
 */

public interface IUserLoginView {
    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
