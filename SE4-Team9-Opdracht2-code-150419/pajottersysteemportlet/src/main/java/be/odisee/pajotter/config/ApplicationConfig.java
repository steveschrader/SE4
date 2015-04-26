package be.odisee.pajotter.config;

import be.odisee.pajotter.dao.*;
import be.odisee.pajotter.service.PajottersSessieService;
import be.odisee.pajotter.service.PajottersSessieServiceImpl;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;     

@Configuration
public class ApplicationConfig {
    
    @Bean
    public BasicDataSource datasource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/pajotters15");
        ds.setUsername("pajotter15user");
        ds.setPassword("pajotter15userpw");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        ds.setDefaultTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);
        return ds;
    }
    
    @Bean (destroyMethod="close")
    public SessionFactory sessionFactory() throws Exception{
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(datasource());
        sf.setPackagesToScan(new String[]{"be.odisee.pajotter.domain"});
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
        sf.setHibernateProperties(hibernateProperties);
        sf.afterPropertiesSet();
        return (SessionFactory) sf.getObject();
    }
    
    
    @Bean
    public TelerDao telerDao(){
        return new TelerHibernateDao();
    }
    
    @Bean
    public HibernateTransactionManager transactionManager() throws Exception{
        return new HibernateTransactionManager(sessionFactory());
    }
    
    @Bean
    public PajottersSessieService pajottersSessieService(){
        PajottersSessieService pss = new PajottersSessieServiceImpl();
        return pss;
    }
}
