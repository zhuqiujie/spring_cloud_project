package cn.com.sandi.qywx.system.service;

/**
 * 定义系统初始化之后的定时器
 */

public interface TimerMoniterService {
    public void openTimerTask_initAppInfoToRedis();

    public void initAppInfoToRedis();


}
