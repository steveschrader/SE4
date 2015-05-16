package be.odisee.pajotterconfig;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;   									
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager; 
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;     
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataConfig {
	
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
    public LocalSessionFactoryBean LocalSessionFactoryBean() throws Exception{
    	LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(datasource());
        sf.setPackagesToScan(new String[]{"be.odisee.pajotter.domain"});
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
        hibernateProperties.put("hibernate.hbm2ddl.auto","create-drop"); 
        sf.setHibernateProperties(hibernateProperties);
        sf.afterPropertiesSet();               
        return sf;
    }
 
    // Aangepast aan Hibernate 4
   /* @Bean (destroyMethod="close")
    public SessionFactory sessionFactory() throws Exception{
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(datasource());
        sf.setPackagesToScan(new String[]{"be.odisee.pajotter.domain"});
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
        hibernateProperties.put("hibernate.hbm2ddl.auto","create-drop"); 
        sf.setHibernateProperties(hibernateProperties);
        sf.afterPropertiesSet();                 // omdat deze configuratie wijze ...
        return (SessionFactory) sf.getObject();  // nog wat scherpe kantjes heeft
    }*/
    
    @Bean (destroyMethod="close")
    public SessionFactory sessionFactory() throws Exception{
    	LocalSessionFactoryBean sf = LocalSessionFactoryBean();
        return (SessionFactory) sf.getObject();  // heeft nog wat scherpe kantjes
    }
    
    @Bean
    public org.hibernate.cfg.Configuration hibernateConfiguration() throws Exception {
    	LocalSessionFactoryBean sf = LocalSessionFactoryBean();
    	return sf.getConfiguration();
    }
    
    @Bean
    public HibernateTransactionManager transactionManager() throws Exception{
        return new HibernateTransactionManager(sessionFactory());
    }    

}
