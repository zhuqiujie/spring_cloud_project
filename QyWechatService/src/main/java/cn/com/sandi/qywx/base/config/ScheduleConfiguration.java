package cn.com.sandi.qywx.base.config;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.ErrorHandler;

import ch.qos.logback.classic.Logger;


/**
 * 使用spring自带的调度机制
 * @author guozp
 *
 */
@Configuration
@EnableScheduling
public class ScheduleConfiguration implements SchedulingConfigurer{

    private static Logger  Logger = (Logger)LoggerFactory.getLogger(ScheduleConfiguration.class);
	
    @Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setTaskScheduler(taskScheduler());
	}

    /**
     * 配置多线程执行调度任务
     * @return
     */
	public ThreadPoolTaskScheduler taskScheduler(){
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(5);
		taskScheduler.setThreadNamePrefix("schedule");
		taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		taskScheduler.setErrorHandler(new ErrorHandler() {
			@Override
			public void handleError(Throwable t) {
				Logger.error("调度线程异常",t);
			}
		});
		return taskScheduler;
	}
}
