package me.sunshu.myokhttp;

/**
 * 创建时间：  17-6-4.
 * 编写人： sunshu
 * 功能描述：
 */

public class CommonHttpUtils {
    private CommonHttpUtils commonHttpUtils;
    private CommonHttpUtils(){};
    public CommonHttpUtils getCommonHttpUtils(){
        if (commonHttpUtils == null){
            return commonHttpUtils = new CommonHttpUtils();
        }else {
            return  commonHttpUtils;
        }
    }



}
