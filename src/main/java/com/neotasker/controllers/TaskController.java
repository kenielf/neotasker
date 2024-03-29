package com.neotasker.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.neotasker.database.HibernateUtil;
import com.neotasker.model.Task;

public class TaskController {

    public void registerTask(Task task) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(task);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateTask(Task task) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(task);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        //try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        //    transaction = session.beginTransaction();

        //    if (Objects.isNull(session.find(Task.class, task.getId()))) {
        //        session.persist(task);
        //    } else {
        //        session.merge(task);
        //    }

        //    transaction.commit();
        //} catch (Exception e) {
        //    if (transaction != null) {
        //        transaction.rollback();
        //    }
        //}
    }

    public Task getTaskById(long id) {
        Transaction transaction = null;
        Task task = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            task = session.get(Task.class, id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return task;
    }

    public List<Task> getAllTasks() {
        Session session = null;
        Transaction transaction = null;
        List<Task> tasks = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            tasks = session.createQuery("FROM Task", Task.class).getResultList();
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

        return tasks;
        //Transaction transaction = null;
        //List<Task> tasks = null;

        //try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        //    transaction = session.beginTransaction();

        //    tasks = session.createQuery("FROM tasks", Task.class).getResultList();

        //    transaction.commit();
        //} catch (Exception e) {
        //    if (transaction != null) {
        //        transaction.rollback();
        //    }
        //}
        //return tasks;
    }

    public void deleteTask(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Task task = getTaskById(id);
            session.remove(task);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
