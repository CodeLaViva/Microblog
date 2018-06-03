package com.lhz.service;

import com.lhz.dao.LoginDao;
import org.springframework.transaction.annotation.Transactional;

public class LoginService {
    private LoginDao loginDao = new LoginDao();

    @Transactional
    public boolean login(String username, String user_password) {
        return loginDao.login(username, user_password);
    }

    public String get_user_id(String username){
        return loginDao.get_user_id(username);
    }
}
