package com.lhz.dao;

import com.lhz.model.Messages;
import com.lhz.util.HibernateUtil;
import org.hibernate.Session;

public class MessagesDao {
    private Session session;


    //添加对象
    public void put_messages(Messages messages) {

        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务

        try {
            session.save(messages);

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交
        //return messages;
    }
}
