package com.example.outopompomme;

public class MemberInfo {
    private String nickname;

    public MemberInfo(String nickname){
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
}
