package com.lhz.dao;

import com.lhz.model.Userinfo;
import com.lhz.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserinfoDao {

    private Session session;

    //添加对象
    public void userinfo(Userinfo userinfo) {

        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务

        try {
            session.save(userinfo);

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交
        //return messages;
    }

    public Userinfo get_userinfo(String user_id) {
        List<Object> list = null;
        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务，存到tx
        try {
            list = session.createQuery("from Userinfo where user_id = :user_id")
                    .setParameter("user_id", user_id)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交

        Userinfo userinfo;
        if (list.size() != 0) {
            userinfo = (Userinfo) list.get(0);
            return userinfo;
        }

        return null;
    }

    public int get_userinfo_id(String user_id) {
        List<Object> list = null;
        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务，存到tx
        try {
            list = session.createQuery("select userinfo_id from Userinfo where user_id = :user_id")
                    .setParameter("user_id", user_id)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交

        if (list.size() != 0) {
            int userinfo_id = (int) list.get(0);
            return userinfo_id;
        }

        return 0;
    }

    public void update_userinfo(Userinfo userinfo) {

        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务，存到tx
        try {
            session.merge(userinfo);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交

    }

}
