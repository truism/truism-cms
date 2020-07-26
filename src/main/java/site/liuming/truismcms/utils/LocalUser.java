package site.liuming.truismcms.utils;

import site.liuming.truismcms.web.pojo.User;

/**
 * 保存当前登录的用户
 */
public class LocalUser {

    private static ThreadLocal<User> localUser = new ThreadLocal<>();

    public static void setLocalUser(User user) {
        localUser.set(user);
    }

    public static User getLocalUser() {
        return localUser.get();
    }

}
