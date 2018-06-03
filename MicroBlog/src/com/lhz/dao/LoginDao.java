package com.lhz.dao;

import com.lhz.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class LoginDao {
    private Session session;

    //添加对象
    public boolean login(String username, String user_password) {
        System.out.println("username: " + username);
        System.out.println("user_password: " + user_password);
        List<Object> list = null;
        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务，存到tx
        try {
            list = session.createQuery("from Users where user_phone = :username or user_id = :username or user_email = :username and user_password = :user_password")
                    .setParameter("username", username)
                    .setParameter("user_password", user_password)
                    .list();

            if (list.size() != 0) {
                String sql = "update Users set user_status = '1' where user_phone = :username or user_id = :username or user_email = :username";
                session.createQuery(sql)
                        .setParameter("username", username);
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交
        return list.size() != 0;
    }

    public String get_user_id(String username) {
        List<Object> list = null;
        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务，存到tx
        try {
            list = session.createQuery("select user_id from Users where user_phone = :username or user_id = :username or user_email = :username")
                    .setParameter("username", username)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交

        if (list.size() != 0) {
            String user_id = (String) list.get(1);
            return user_id;
        }

        return "false";
    }

}
