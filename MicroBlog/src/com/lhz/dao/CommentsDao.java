package com.lhz.dao;

import com.lhz.model.Comments;
import com.lhz.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CommentsDao {

    private Session session;

    //添加对象
    public void put_comments(Comments comments) {

        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务

        try {
            session.merge(comments);

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交
        //return messages;
    }

    public List<Comments> get_comments(String user_id) {
        List<Comments> list = null;

        List comments_list = new ArrayList();

        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务，存到tx
        try {
            list = session.createQuery("from Comments where user_id = :user_id")
                    .setParameter("user_id", user_id)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交

        if (list.size() != 0) {
            comments_list.addAll(list);
            return comments_list;
        }

        return null;
    }

    public int get_comments_id(int messages_id, String user_id) {
        List<Object> list = null;
        session = HibernateUtil.openSession();
        session.beginTransaction();    //开始事务，存到tx
        try {
            list = session.createQuery("select comments_id from Comments where messages_id = :messages_id and user_id = :user_id")
                    .setParameter("messages_id", messages_id)
                    .setParameter("user_id", user_id)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }

        session.getTransaction().commit();   //事务提交

        if (list.size() != 0) {
            int comments_id = (int) list.get(0);
            return comments_id;
        }

        return 0;
    }
}
