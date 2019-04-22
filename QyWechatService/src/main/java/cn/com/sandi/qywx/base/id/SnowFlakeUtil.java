package cn.com.sandi.qywx.base.id;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import ch.qos.logback.classic.Logger;

public class SnowFlakeUtil {
    private static Logger logger = (Logger) LoggerFactory.getLogger(SnowFlakeUtil.class);
    private static SnowFlake snowFlake;

    static {
        try {
            Properties pro = PropertiesLoaderUtils.loadAllProperties("application.properties");
            String nowPro = pro.getProperty("spring.profiles.active");
            Properties nowProPerties = PropertiesLoaderUtils.loadAllProperties("application-" + nowPro + ".properties");
            Long dataCenterId = Long.parseLong((String) nowProPerties.get("snowFlake.datacenterId"));
            Long machineId = Long.parseLong((String) nowProPerties.get("snowFlake.machineId"));
            logger.debug("数据中心id:" + dataCenterId + ",机器id:" + machineId);
            snowFlake = new SnowFlake(dataCenterId, machineId);
        } catch (IOException e) {
            logger.error("无法加载properties文件", e);
        }
    }

    public static long newId() {
        return snowFlake.nextId();
    }
}
