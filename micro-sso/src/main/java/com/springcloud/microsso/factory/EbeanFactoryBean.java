package com.springcloud.microsso.factory;

import com.springcloud.microcommon.domain.CurrentUser;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.CurrentUserProvider;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer>, CurrentUserProvider {

    @Autowired
    CurrentUser currentUser;

    @Autowired
    DataSource dataSource;

    @Override
    public EbeanServer getObject() throws Exception {

        ServerConfig config = new ServerConfig();
        config.setName("db");
        config.setCurrentUserProvider(currentUser);

        // set the spring's datasource and transaction manager.
        config.setDataSource(dataSource);
        config.setRunMigration(true);
        config.setExternalTransactionManager(new SpringJdbcTransactionManager());

        config.loadFromProperties();

        return EbeanServerFactory.create(config);
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * Return the current user id.
     * <p>
     * The type returned should match the type of the properties annotated
     * with @WhoCreated and @WhoModified. These are typically String, Long or UUID.
     * </p>
     */
    @Override
    public Object currentUser() {
        return "System";
    }
}