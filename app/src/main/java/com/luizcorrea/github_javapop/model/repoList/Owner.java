package com.luizcorrea.github_javapop.model.repoList;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Owner implements Serializable {

    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String url;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}