package cn.com.sandi.qywx.system.service.impl;

import cn.com.sandi.qywx.base.jpa.service.GenericService;
import cn.com.sandi.qywx.base.utils.QywxHttpUtils;
import cn.com.sandi.qywx.base.utils.UrlsConstants;
import cn.com.sandi.qywx.appInfo.model.QywxAppInfo;
import cn.com.sandi.qywx.appInfo.model.QywxAppInfoExt;
import cn.com.sandi.qywx.deptUser.service.QywxDeptUserService;
import cn.com.sandi.qywx.system.service.TimerMoniterService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 定义系统初始化之后的定时器
 */

@Service("timerMoniterService")
public class TimerMoniterServiceImpl implements TimerMoniterService{

    private static Logger logger = (Logger) LoggerFactory.getLogger(TimerMoniterServiceImpl.class);
    @Autowired
    private QywxDeptUserService qywxDeptUserService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private GenericService<QywxAppInfo,Long> qywxAppInfoService;


    /**
     * 定义定时器
     */

    public void openTimerTask_initAppInfoToRedis(){
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                initAppInfoToRedis();
            }
            //执行之前50毫秒延迟  access_token两小时失效，设置110min刷新一次redis
        },50,110*60*1000);
    }


    /**
     * 获取所有应用的access_token,存redis
     */

    public void initAppInfoToRedis(){
        //获取所有的应用信息
        List<QywxAppInfo> qywxAppInfos = qywxAppInfoService.getAll();
        //遍历所有的应用信息，获取access_token,存入redis

        Map<String,Object> paraMap = null;

        QywxAppInfoExt qywxAppInfoExt = null;

        for(QywxAppInfo qywxAppInfoDB :qywxAppInfos){
            paraMap = new HashMap<>();
            qywxAppInfoExt = new QywxAppInfoExt();

            logger.info(qywxAppInfoDB.getCorpId());
            logger.info(qywxAppInfoDB.getSecret());
            paraMap.put(UrlsConstants.ACCESS_TOKEN_URL_CORPID,qywxAppInfoDB.getCorpId());

            paraMap.put(UrlsConstants.ACCESS_TOKEN_URL_CORPSECRET,qywxAppInfoDB.getSecret());

            String returnStr = QywxHttpUtils.doGet(UrlsConstants.ACCESS_TOKEN_URL,paraMap);

            logger.info(qywxAppInfoDB.getAppName()+"的获取access_token返回信息是："+returnStr);

            Map<String,Object> returnMap = (Map<String,Object>) JSONObject.parse(returnStr);

            BeanUtils.copyProperties(qywxAppInfoDB,qywxAppInfoExt);

            String errmsg = returnMap.get("errmsg").toString();

            if(errmsg.equals("ok")){
                qywxAppInfoExt.setAccess_token(returnMap.get("access_token").toString());
            }else {
                logger.info(qywxAppInfoDB.getAppName()+"无法获取access_token信息");
            }

            //存redis  默认两小时后过期  corpId_agentId
            stringRedisTemplate.opsForValue().set(qywxAppInfoDB.getCorpId()+"_"+qywxAppInfoDB.getAgentId(), JSON.toJSONString(qywxAppInfoExt),2, TimeUnit.HOURS);
            //List<QywxDeptUser> workTimeList =JSON.parseArray(workTimeRedis,WeChatWorkDurTime.class);
        }

    }


}
