package com.zheng.conf;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan("com.zheng")
@EnableTransactionManagement
public class Spring {
    @Autowired
    private  PropertiesConf propertiesConf;
    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(propertiesConf.getDriver());
        hikariDataSource.setJdbcUrl(propertiesConf.getUrl());
        hikariDataSource.setUsername(propertiesConf.getUsername());
        hikariDataSource.setPassword(propertiesConf.getPassword());
        return hikariDataSource;
    }
    @Autowired
    private DataSource dataSource;
    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean()  {
        LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        Properties properties=new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.setProperty("hibernate.format_sql","true");
         properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        localSessionFactoryBean.setHibernateProperties(properties);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver=new PathMatchingResourcePatternResolver();
        localSessionFactoryBean.setMappingLocations(pathMatchingResourcePatternResolver.getResource("hibernate.hbm.xml"));
        return localSessionFactoryBean;
    }
@Autowired
SessionFactory localSessionFactoryBean;
    @Bean
    public HibernateTemplate hibernateTemplate(){
        HibernateTemplate hibernateTemplate=new HibernateTemplate(localSessionFactoryBean);
        return hibernateTemplate;
    }

  @Bean
    public HibernateTransactionManager hibernateTransactionManager() throws PropertyVetoException {
      HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(localSessionFactoryBean);
      return hibernateTransactionManager;
  }
}