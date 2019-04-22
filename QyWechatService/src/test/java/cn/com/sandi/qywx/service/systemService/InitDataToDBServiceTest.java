package cn.com.sandi.qywx.service.systemService;

import cn.com.sandi.qywx.system.service.GetDataFromQywxService;
import cn.com.sandi.qywx.system.service.InitDataToDBService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InitDataToDBServiceTest {

    @Autowired
    private InitDataToDBService initDataToDBService;
    @Autowired
    private GetDataFromQywxService getDataFromQywxService;
    @Test
    public void saveDeptList() {
        /**
         * corpId wwd6a6821842f0746c
         * agentId 1000004
         */
        String jsonStr = getDataFromQywxService.getDeptByAgentIdFromQywx("wwd6a6821842f0746c","1000004",null);

        Map<String, Object> map = JSON.parseObject(jsonStr);

        initDataToDBService.saveDeptUserList("wwd6a6821842f0746c","1000004",map.get("department").toString());

    }
}