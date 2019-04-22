package cn.com.sandi.qywx.base.jpa.filter;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class ModelScanFilter {
   private String annotation;
   
   private String[] basePackage;
   
   
   
   public ModelScanFilter(String annotation, String[] basePackage) {
		super();
		this.annotation = annotation;
		this.basePackage = basePackage;
   }

   public Set<BeanDefinitionHolder> getBeanDefinitionHolderSet(){
	   Set<BeanDefinitionHolder> set = null;
	   BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
	   CustomClassPathBeanDefinitionScanner scanner = new CustomClassPathBeanDefinitionScanner(registry, false);
	   final String annotationType = this.annotation;
	   TypeFilter includeFilter = new TypeFilter(){
           @Override
           public boolean match(MetadataReader arg0, MetadataReaderFactory arg1) throws IOException {
               boolean result = false;
               //拥有annotationInterface指定的注解的类（非抽象）
               if (arg0.getClassMetadata().isConcrete() && arg0.getAnnotationMetadata().hasAnnotation(annotationType)) {
                   result = true;
               }
               return result;
           }
       };
       scanner.addIncludeFilter(includeFilter);
       
       set = scanner.doScan(basePackage);
	   return set;
   }

	public String getAnnotation() {
		return annotation;
	}
	
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	
	public String[] getBasePackage() {
		return basePackage;
	}
	
	public void setBasePackage(String[] basePackage) {
		this.basePackage = basePackage;
	}
   
   
}
