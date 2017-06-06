package me.sunshu.mvp.login.biz;

/**
 * 创建时间：  17-6-4.
 * 编写人： sunshu
 * 功能描述：
 */

public abstract class IUserBiz {
    public abstract void login(String username,String password,OnLoginListener loginListener);
}
