package me.sunshu.mvp.login.biz;

import me.sunshu.mvp.common.ErrorBean;
import me.sunshu.mvp.login.bean.User;

/**
 * 创建时间：  17-6-4.
 * 编写人： sunshu
 * 功能描述：
 */

public interface OnLoginListener {
    void onLoginSuccess(User user);
    void onLoginFailed(ErrorBean errorBean);
}
