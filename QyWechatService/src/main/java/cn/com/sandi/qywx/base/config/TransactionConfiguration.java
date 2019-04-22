package cn.com.sandi.qywx.base.config;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //开启注解事务
@ImportResource("classpath:spring/spring-transaction.xml")
public class TransactionConfiguration {
	
	/*//配置事务
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
	      return new DataSourceTransactionManager(dataSource);
	}*/
	@Resource(name="customEntityManagerFactory")
	private EntityManagerFactory entityManagerFactory;
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager txManager() {
	      return new JpaTransactionManager(entityManagerFactory);
	}
}
