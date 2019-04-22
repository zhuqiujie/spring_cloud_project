package cn.com.sandi.qywx.service.impl;

import ch.qos.logback.classic.Logger;
import cn.com.sandi.qywx.base.utils.QywxHttpUtils;
import cn.com.sandi.qywx.deptUser.query.QywxDeptUserCriteria;
import cn.com.sandi.qywx.deptUser.service.QywxDeptUserService;
import cn.com.sandi.qywx.deptUser.model.QywxDeptUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QywxDeptUserServiceImplTest {

    @Resource
    private QywxDeptUserService qywxDeptUserService;
    private static Logger logger = (Logger) LoggerFactory.getLogger(QywxDeptUserServiceImplTest.class);

    @Test
    public void contextLoads() {
    }

    @Test
    public void insertQYWXDeptUser() {
        QywxDeptUser qywxDeptUser = new QywxDeptUser();
        qywxDeptUser.setDeptId(2L);
        qywxDeptUser.setDeptOrder(1L);
        qywxDeptUser.setIsLeaderInDept(1);
        qywxDeptUser.setUserId(123L);
        qywxDeptUserService.insertQYWXDeptUser(qywxDeptUser);
    }

    @Test
    public void updateQYWXDeptUser() {
        QywxDeptUser qywxDeptUser = qywxDeptUserService.getQYWXDeptUserById(310462900647104512L);
        qywxDeptUser.setUserId(564L);
        qywxDeptUserService.updateQYWXDeptUser(qywxDeptUser);
    }

    @Test
    public void getQYWXDeptUserById() {
        qywxDeptUserService.getQYWXDeptUserById(310462900647104512L);
    }

    @Test
    public void findByDeptId() {
        List<QywxDeptUser> list = qywxDeptUserService.findByDeptId(2L);
        logger.info(list.toString());
    }

    @Test
    public void queryQYWXDeptUserList() {
       // List<QywxDeptUser> list = qywxDeptUserService.queryQYWXDeptUserList();
        QywxDeptUserCriteria criteria = new QywxDeptUserCriteria();
        criteria.setRows(10);
        criteria.setIndex(0);
        criteria.setDeptId(2L);
        criteria.setUserId("zhuqiujieTEST");
        List<QywxDeptUser> list = qywxDeptUserService.queryQYWXDeptUserList(criteria);
        logger.info(list.toString());
    }

    @Test
    public void doGet(){
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("corpid","wwd6a6821842f0746c");
        map.put("corpsecret","O-hWmMqsBjp5bSUU_Nz3U5Lpy7OfQcBR7E7IU5_7edw");

        String jsonStr = QywxHttpUtils.doGet(url,map);
        Map<String,Object> json = (Map<String,Object>) com.alibaba.fastjson.JSONObject.parse(jsonStr);
        logger.info(json.toString());

    }




}