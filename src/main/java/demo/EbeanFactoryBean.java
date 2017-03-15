package demo;


import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;



/**
 * Spring factory for creating the EbeanServer singleton.测试文件
 */
@Configuration
public class EbeanFactoryBean {
	
    @Bean
    public ServerConfig ebeanServerConfig(DataSource dataSource) {
        ServerConfig config = new ServerConfig();
        config.setName("ebeanServer");
        config.setDefaultServer(true);
        config.setDataSource(dataSource);
        config.addPackage("com.clevergang.dbtests.repository.impl.ebean.entities");
        config.setExternalTransactionManager(new SpringJdbcTransactionManager());
        config.setAutoCommitMode(false);
        config.setExpressionNativeIlike(true);
        return config;
    }

    @Bean
    public EbeanServer ebeanServer(ServerConfig serverConfig) {
        return EbeanServerFactory.create(serverConfig);
    }

}
