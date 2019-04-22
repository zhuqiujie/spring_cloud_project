package cn.com.sandi.qywx.system.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统初始化之后要开启定时器，读写库，读写redis
 */
@Service
public class InitAppDataService implements InitializingBean{

    @Autowired
    private TimerMoniterService timerMoniterService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //开启定时器
        timerMoniterService.openTimerTask_initAppInfoToRedis();
    }

}
