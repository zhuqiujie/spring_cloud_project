package cn.com.sandi.qywx.base.jpa.processor;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Properties;
import java.util.Set;

import javax.persistence.Entity;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import cn.com.sandi.qywx.base.id.SnowFlake;
import cn.com.sandi.qywx.base.jpa.annotation.WithGenericService;
import cn.com.sandi.qywx.base.jpa.dao.GenericDaoImpl;
import cn.com.sandi.qywx.base.jpa.filter.ModelScanFilter;
import cn.com.sandi.qywx.base.jpa.service.GenericServiceImpl;
import ch.qos.logback.classic.Logger;


@Configuration
public class CustomBeanDefinitionRegistryPostProcessor implements
		BeanDefinitionRegistryPostProcessor,ApplicationContextAware {

	private static String[] scanGenerateServicePackage;

	private static Logger logger = (Logger) LoggerFactory.getLogger(CustomBeanDefinitionRegistryPostProcessor.class);
	
	private ApplicationContext applicationContext;
	
	static {
        try {
            Properties pro = PropertiesLoaderUtils.loadAllProperties("application.properties");
            String nowPro = pro.getProperty("spring.profiles.active");
            Properties nowProPerties = PropertiesLoaderUtils.loadAllProperties("application-" + nowPro + ".properties");
            String packageString = (String) nowProPerties.get("jpa.packagesToScan");
            scanGenerateServicePackage = packageString.split(",");
            logger.info("需要扫描的package范围（自动生成GenericService）："+scanGenerateServicePackage);
        } catch (IOException e) {
            logger.error("无法加载properties文件", e);
        }
    }
	
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
       logger.info("postProcessBeanFactory:初始化");
       DefaultListableBeanFactory defaultBeanFactory = (DefaultListableBeanFactory) beanFactory;
       ModelScanFilter scanFilter = new ModelScanFilter(Entity.class.getName(), scanGenerateServicePackage);
       Set<BeanDefinitionHolder> beanSet =  scanFilter.getBeanDefinitionHolderSet();
       
       for (BeanDefinitionHolder holder : beanSet) {
           try {
               Class<?> cls = Class.forName(holder.getBeanDefinition().getBeanClassName());
               if (cls.getAnnotations()!=null && cls.getAnnotations().length>0) {
            	   logger.info("扫描到model:"+holder.getBeanName());
                   for (Annotation annotation : cls.getAnnotations()) {
                       if (annotation instanceof Entity) {
                           BeanDefinitionBuilder b =
                                   BeanDefinitionBuilder.rootBeanDefinition(GenericDaoImpl.class)
                                                        .addConstructorArgValue(cls)
                                                        .addPropertyReference("entityManagerFactory", "customEntityManagerFactory");
                           defaultBeanFactory.registerBeanDefinition(holder.getBeanName()+"Dao", b.getBeanDefinition());
                           logger.info("spring 容器初始化，registerBean："+holder.getBeanName()+"Dao");
                       }else if(annotation instanceof WithGenericService){
                    	   BeanDefinitionBuilder buildService =
                                   BeanDefinitionBuilder.rootBeanDefinition(GenericServiceImpl.class)
                                                        .addConstructorArgReference(holder.getBeanName()+"Dao");
                           defaultBeanFactory.registerBeanDefinition(holder.getBeanName()+"Service", buildService.getBeanDefinition());
                           logger.info("model:"+holder.getBeanName()+" 配置使用GenericService");
                           logger.info("spring 容器初始化，registerBean："+holder.getBeanName()+"Service");
                       }
                   }
               }
           }catch(Exception ex) {
               logger.error("", ex);
           }
       }
       printAllBeans();
	}

	@Override
	public void postProcessBeanDefinitionRegistry(
			BeanDefinitionRegistry registry) throws BeansException {		
		logger.debug("postProcessBeanDefinitionRegistry:加载bean");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void printAllBeans() {
		String[] beans = applicationContext.getBeanDefinitionNames();
		for (String beanName : beans) {
			Class<?> beanType = applicationContext.getType(beanName);
			logger.debug("BeanName:" + beanName);
			logger.debug("Bean的类型：" + beanType);
			logger.debug("Bean所在的包：" + beanType.getPackage());
		}
		logger.debug("load Bean over!" );
	}

	
}