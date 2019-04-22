package cn.com.sandi.qywx.service.systemService;

import ch.qos.logback.classic.Logger;
import cn.com.sandi.qywx.deptUser.service.QywxDeptUserService;
import cn.com.sandi.qywx.service.impl.QywxDeptUserServiceImplTest;
import cn.com.sandi.qywx.system.service.GetDataFromQywxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetDataFromQywxServiceTest {
    @Resource
    private QywxDeptUserService qywxDeptUserService;
    private static Logger logger = (Logger) LoggerFactory.getLogger(QywxDeptUserServiceImplTest.class);

    @Autowired
    private GetDataFromQywxService getDataFromQywxService;
    @Test
    public void getDeptByAgentIdFromQywx() {

        String corpId = "wwd6a6821842f0746c";

        String agentId1 = "1000002";//我的工单

        String agentId2 = "1000004";//集福活动

        String returnStr1 = getDataFromQywxService.getDeptByAgentIdFromQywx(corpId,agentId1,null);
        String returnStr2 = getDataFromQywxService.getDeptByAgentIdFromQywx(corpId,agentId2,null);

        logger.info(returnStr1);
        logger.info(returnStr2);
    }

    @Test
    public void getUserByCorpIdFromQywx() {

        String corpId = "wwd6a6821842f0746c";

        String agentId1 = "1000002";//我的工单

        String agentId2 = "1000004";//集福活动

        Long corpDeptIdAll = 5L;
        Long corpDeptIdCS = 5L;//测试部

        Integer fetchChild = Integer.valueOf(1);

        String returnStr1 = getDataFromQywxService.getUserByCorpIdFromQywx(corpId,agentId1,corpDeptIdCS,fetchChild);
        String returnStr2 = getDataFromQywxService.getUserByCorpIdFromQywx(corpId,agentId2,corpDeptIdAll,fetchChild);
        logger.info(returnStr1);
        logger.info(returnStr2);
    }

    @Test
    public void getUserInfoFromQywx() {
        String corpId = "wwd6a6821842f0746c";
        String agentId2 = "1000004";//集福活动
        String code = "bUG0kCvJLKNswRf85_8MHDuy9Juhasqpe381wTjJMNc";

        String returnStr2 = getDataFromQywxService.getUserInfoFromQywx(corpId,agentId2,code);

        logger.info(returnStr2);
    }
}