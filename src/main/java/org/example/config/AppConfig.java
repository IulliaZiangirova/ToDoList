package org.example.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AppConfig {
//    @Bean
//    public LocalSessionFactoryBean getSessionFactoryBean(){
//        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
//        localSessionFactoryBean.setDataSource(getDataSource());
//        localSessionFactoryBean.setPackagesToScan("org.example.domain");
//        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
//        return localSessionFactoryBean;
//    }
//
//    @Bean
//    public DataSource getDataSource(){
//        Properties props = new Properties();
//        FileInputStream fis = null;
//        MysqlDataSource mysqlDS = null;
//        try{
//            fis = new FileInputStream("src/main/resources/dp.properties");
//            props.load(fis);
//            mysqlDS = new MysqlDataSource();
//            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
//            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
//            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return mysqlDS;
//    }
//
//    private Properties hibernateProperties(){
//        Properties props = new Properties();
//        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//        props.put(Environment.HBM2DDL_AUTO, "validate");
//        return  props;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager (EntityManagerFactory entityManagerFactory){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
}
