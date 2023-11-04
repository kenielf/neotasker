package com.neotasker.database;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.neotasker.model.Task;
import com.neotasker.model.Tag;
import com.neotasker.util.OperatingSystem;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate Settings
                Properties settings = new Properties();

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.DIALECT, "org.hibernate.community.dialect.SQLiteDialect");
                settings.put(Environment.DRIVER, "org.sqlite.JDBC");
                settings.put(
                    Environment.URL,
                    String.format("jdbc:sqlite:%s", new OperatingSystem().getDatabaseFile().toString())
                );
                settings.put(Environment.HBM2DDL_AUTO, "update");
                settings.put(Environment.GENERATE_STATISTICS, "true");

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
}
