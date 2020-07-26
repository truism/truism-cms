package site.liuming.truismcms.vo;

import site.liuming.truismcms.sys.pojo.User;

public class LoginUserVo {

    private User user;

    private String token;

    public LoginUserVo() {
    }

    public LoginUserVo(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
