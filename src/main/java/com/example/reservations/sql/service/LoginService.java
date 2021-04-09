package com.example.reservations.sql.service;

import com.example.reservations.sql.dao.LoginDao;

public class LoginService {

    private LoginDao loginDao;

    public LoginService() {
        this.loginDao = new LoginDao();
    }

    public boolean check(String username, String password) {
        return loginDao.validate(username, password);
    }
}
