package com.lhz.dao;

import com.lhz.model.Users;
import com.lhz.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UsersDao {
    private Session session;

    //添加对象
    public void put_users(Users user) {

        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务

        try {
            session.save(user);

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交
        //return messages;
    }

    public Users get_users(String user_id) {
        System.out.println("user_id: " + user_id);
        List<Object> list = null;
        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务

        try {
            list = session.createQuery("from Users where user_id= :user_id")
                    .setParameter("user_id", user_id)
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交

        Users user = new Users();
        assert list != null;
        if (list.size() != 0) {
            user = (Users) list.get(0);
        }

        return user;
    }

}
