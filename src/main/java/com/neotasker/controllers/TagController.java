package com.neotasker.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.neotasker.database.HibernateUtil;
import com.neotasker.model.Tag;

public class TagController {

    public void registerTag(Tag task) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(task);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //if (transaction != null) {
            //    e.printStackTrace();
            //    transaction.rollback();
            //}
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
