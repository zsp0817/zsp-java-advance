package com.zsp.redis.domain;

/**
 * Created by zhangshaopeng on 2021/9/3.
 */
public class User {

    private String userName;
    private String nickName;

    public User() {
    }

    public User(String userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
