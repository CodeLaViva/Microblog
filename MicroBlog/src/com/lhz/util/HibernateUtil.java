package com.lhz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    //创建SessionFactory对象
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    //创建Session对象
    private static Session session = sessionFactory.openSession();
    public static Session openSession() {
        return session;
    }
}
