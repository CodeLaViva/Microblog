package com.lhz.util;

import com.lhz.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.sql.Timestamp;

public class Hibernate_Test {
    //创建SessionFactory对象
    private SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
    //创建Session对象
    private Session session = sessionFactory.openSession();


    /*@Test
    public void update_test() {
        session.beginTransaction(); // 开启事务
        try {
            Voter voter = new Voter(1002, Date.valueOf("2018-05-12"), "voter2", "123");
            session.save(voter);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }
        session.getTransaction().commit();  // 提交事务
    }*/

   /* @Test
    public void delete_test() {
        try {
            session.beginTransaction(); // 开启事务
            //方式一
                   *//*       Student s = new Student();
                             s.setId(2);
                             session.delete(s);*//*
            //方式二
            //先查询再删除
            Voter voter = session.get(Voter.class, 1002);
            //Voter voter2 = session.get(Voter.class, key);
            if (voter != null) {
                session.delete(voter);
            }
            //提交事务
            System.out.println(voter);  //输出：Voter
            session.getTransaction().commit();  // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }*/

    /*@Test
    public void change_test() {
        session.beginTransaction(); // 开启事务
        try {
            *//**
             * 参数
             * class：要查询的实体类的class
             * Serializable：要查询的对象的主键号
             *//*
            //先查询
            Voter voter = session.get(Voter.class, 1001);
            //再修改
            voter.setVote_username("change");
            //不需要调用update方法
            System.out.println(voter);  //输出：Voter
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
    }*/

    /*@Test
    public void query(){
        List<Object> list = null;
        session.beginTransaction(); // 开启事务
        try {
            list = session.createQuery("select vote_date from Voter where vote_username = :vote_username")
                    .setParameter("vote_username", "voter2").list();
            Date date = (Date) list.get(0);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
    }*/

   /* @Test
    public void query_test() {
        session.beginTransaction(); // 开启事务
        try {
            //查询一个
            //参数一：查询的类型
            //参数二：查询的id
            //       Student stu = (Student)session.get(Student.class, 3);
            //       System.out.println(stu);

            //查询多个
            List<Object> list2 = session.createQuery(" from Voter where vote_password = :password")
                    .setParameter("password", "123").list();
            for (Object s : list2) {
                System.out.println(s);
            }
            List<Object> list = session.createQuery("from Voter ").list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();  // 提交事务
    }*/

    @Test
    public void update_test() {
        session.beginTransaction(); // 开启事务
        try {
            Users user = new Users();
            user.setUser_id("lhz");
            user.setUser_phone("18202738039");
            user.setUser_email("360697507@qq.com");
            user.setUser_password("123");
            user.setUser_nikename("NullPointer");
            user.setUser_time(new Timestamp(new java.util.Date().getTime()));
            user.setUser_status(1);
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();    // 回滚事务
        }
        session.getTransaction().commit();  // 提交事务
    }

}
