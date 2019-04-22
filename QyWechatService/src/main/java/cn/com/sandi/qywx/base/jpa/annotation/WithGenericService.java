package cn.com.sandi.qywx.base.jpa.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * 被注解的model类，自动生成GenericService对象。
 * 
 * controller层如何引用？
 * @Resource
 * private GenericService<modelName,Long> modelName+Service;
 * eg. 
 *     @Resource
 *     private GenericService<Wxapp,Long> wxappService;
 *     
 *  另外底层支持对model包里面的@Entity注解的model类，自动生成GenericDao对象。
 *  如何引用？
 *  @Resource
 *	private GenericDao<modelName, Long> modelName+Dao;
 *  eg.
 *      @Resource
 *      private GenericDao<Book, Long> bookDao; 
 *  
 *  @author guozp
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WithGenericService {
    String value() default "";
}
