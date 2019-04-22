package cn.com.sandi.qywx.base.jpa.filter;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class CustomClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner{

	public CustomClassPathBeanDefinitionScanner(
			BeanDefinitionRegistry registry, boolean useDefaultFilters) {
		super(registry, useDefaultFilters);
	}

	public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
