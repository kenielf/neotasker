package com.neotasker.database;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.neotasker.model.Task;
import com.neotasker.model.Tag;
import com.neotasker.platform.OperatingSystem;

/**
 * This class is responsible for managing {@link org.hibernate.Hibernate}
 * sessions.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    /**
     * This function is responsible for creating sessions to be used in 
     * transactions externally. Some of the properties are marked as 
     * deprecated, however, when using the newer ones, the SQliteDialect seems 
     * to misbehave.
     * 
     * @return the sessionFactory static variable.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate Settings
                Properties settings = new Properties();

                settings.put(Environment.SHOW_SQL, "false");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.DIALECT, "org.hibernate.community.dialect.SQLiteDialect");
                settings.put(Environment.URL, String.format(
                        "jdbc:sqlite:%s",
                        OperatingSystem.getDatabaseFile().toString()
                    )
                );
                settings.put(Environment.HBM2DDL_AUTO, "update");
                settings.put(Environment.GENERATE_STATISTICS, "false");

                configuration.setProperties(settings);

                // Classes
                configuration.addAnnotatedClass(Task.class);
                configuration.addAnnotatedClass(Tag.class);

                // Registry
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }

    /**
     * This method is responsible for opening the very first session, making
     * sure the database is properly created.
     */
    public static void Initialize() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }
}


