package cn.com.sandi.qywx.base.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@EnableJpaRepositories(basePackages="${jpa.repository_base_package}",
                       entityManagerFactoryRef="customEntityManagerFactory",
                       transactionManagerRef="transactionManager")
public class JpaConfiguration {
	    
	    @Value("${jpa.packagesToScan}")
	    private String[] packagesToScan;
	
	    @Resource
	    private DataSource dataSource;
	
	    
	    @Bean(name="customEntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean createContainerEntityManagerFactoryBean() {
	        LocalContainerEntityManagerFactoryBean factory = new
	                LocalContainerEntityManagerFactoryBean();
	        factory.setDataSource(dataSource);
	        factory.setPackagesToScan(packagesToScan);
	        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        return factory;
	    }


		public String[] getPackagesToScan() {
			return packagesToScan;
		}


		public void setPackagesToScan(String[] packagesToScan) {
			this.packagesToScan = packagesToScan;
		}


		public DataSource getDataSource() {
			return dataSource;
		}


		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}
	 
	    

}
