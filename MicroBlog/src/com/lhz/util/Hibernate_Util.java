package com.lhz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Hibernate_Util {

    //创建SessionFactory对象
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    //创建Session对象
    private static Session session = sessionFactory.openSession();

    /**
     * update方法用于执行数据库的“增”操作，如果相关的表不存在，那么会自动创建新表
     *
     * @param object 需要进行update的实体类对象
     */
    //update
    public static void update(Object object) {
        session.beginTransaction(); // 开启事务
        try {
            session.save(object);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }
        session.getTransaction().commit();  // 提交事务
    }

    /**
     * delete方法用于执行数据库的“删”操作，如果相关的表不存在，那么会自动创建新表
     *
     * @param key 需要删除的数据库对象的主键
     */
    //delete
    /*public static void delete(int key) {
        session.beginTransaction(); // 开启事务
        try {
            //方式一
            *//*Student s = new Student();
            s.setId(2);
            session.delete(s);*//*

            //先查询再删除
            Voter voter = session.get(Voter.class, key);
            if (voter != null) {
                session.delete(voter);
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
    }*/

    /**
     * change方法用于执行数据库的“改”操作
     *
     * @param object 传入需要执行修改的对象
     */
    /*//change
    public static void change(Object object) {
        session.beginTransaction(); // 开启事务
        try {
            //调用update方法进行修改操作
            session.update(object);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
    }*/

    /**
     * query方法用于执行数据库的“查”操作
     *
     * //@param tableName 数据库需要查询的表的名字
     * @return List 返回一个List对象，存储查询到的结果,list对象List<Object>
     * */
    /*//query
    public static List query() {
        List<Object> list = null;
        session.beginTransaction(); // 开启事务
        try {
            list = session.createQuery("from User ").list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
        return list;
    }*/

    /**
     * queryVoter方法用于执行对数据库表 voter 的“查”操作
     *
     * @return List 返回一个List对象，存储查询到的结果,list对象List<Object>
     * */
    /*//query
    public static List queryVoter() {
        List<Object> list = null;
        session.beginTransaction(); // 开启事务
        try {
            list = session.createQuery("from Voter ").list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
        return list;
    }*/

    /**
     * query方法用于执行数据库的“查”操作
     * 此query方法用以执行vote时的数据库查询操作
     *
     * @param vote_username 当前投票的用户名，用以数据库查询匹配
     * @return Voter 返回一个Voter对象
     * */
    /*//query
    public static Voter query(String vote_username) {
        List<Object> list = null;
        Voter voter = null;
        Date date = null;
        session.beginTransaction(); // 开启事务
        try {
            list = session
                    .createQuery(" from Voter where vote_username = :vote_username")
                    .setParameter("vote_username", vote_username)
                    .list();
            voter = (Voter) list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
        return voter;
    }*/

    /**
     * query方法用于执行数据库的“查”操作
     * 此query方法用以执行vote时的数据库查询操作
     *
     * @param username 当前被投票的用户名，用以数据库查询匹配
     * @param flag 用于区分query(String vote_username)方法
     * @return User 返回一个Date值，用于后台获取当前投票者上次投票时间
     * */
    /*//query
    public static User query(String username, int flag) {
        List<Object> list = null;
        User user = null;
        session.beginTransaction(); // 开启事务
        try {
            list = session
                    .createQuery(" from User where username = :username")
                    .setParameter("username", username)
                    .list();
            user = (User) list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
        return user;
    }*/

    /**
     * query方法用于执行数据库的“查”操作
     * 此query方法用以执行login时的数据库查询操作
     *
     * @param vote_username 登录时输入的用户名，用以数据库查询匹配
     * @param vote_password 登录时输入的密码，用以数据库查询匹配
     * @return boolean 返回一个Boolean值(list.size() != 0)，如果查询到账号密码，则返回true，如果未查到匹配对象，则返回false
     * */
    //query
    public static boolean query(String vote_username, String vote_password) {
        List<Object> list = null;
        session.beginTransaction(); // 开启事务
        try {
            list = session.createQuery("from Voter where vote_username = :vote_username and vote_password = :vote_password")
                    .setParameter("vote_username", vote_username)
                    .setParameter("vote_password", vote_password)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
        return list.size() != 0;
    }
}
