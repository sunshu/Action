package me.sunshu.mvp.login.biz;

import me.sunshu.mvp.common.ErrorBean;
import me.sunshu.mvp.login.bean.User;

/**
 * 创建时间：  17-6-4.
 * 编写人： sunshu
 * 功能描述：
 */

public class UserBiz extends IUserBiz{

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (username.equals("sun") && password.equals("111")){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.onLoginSuccess(user);
                }else{
                    ErrorBean bean = new ErrorBean();
                    bean.setErrorCode("1");
                    bean.setErrorMsg("网络错误");
                    loginListener.onLoginFailed(bean);
                }

            }
        }.start();
    }
}
