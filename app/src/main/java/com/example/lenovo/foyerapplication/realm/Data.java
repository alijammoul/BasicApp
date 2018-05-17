package com.example.lenovo.foyerapplication.realm;

import io.realm.RealmObject;

/**
 * Created by Lenovo on 08/10/2017.
 */

public class Data extends RealmObject {
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String username;
    String password;
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }




}
