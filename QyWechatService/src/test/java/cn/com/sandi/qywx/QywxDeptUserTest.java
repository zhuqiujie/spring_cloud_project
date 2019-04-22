package cn.com.sandi.qywx;

import cn.com.sandi.qywx.deptUser.model.QywxDeptUser;
import cn.com.sandi.qywx.deptUser.service.QywxDeptUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QywxDeptUserTest {

    @Resource
    private QywxDeptUserService qYWXDeptUserService;

    @Test
    public void contextLoads() {
    }
    @Test
    public void testInsetInsertQYWXDeptUser(){
        QywxDeptUser qywxDeptUser = new QywxDeptUser();
        qywxDeptUser.setDeptId(2L);
        qywxDeptUser.setDeptOrder(2L);
        qywxDeptUser.setIsLeaderInDept(1);
        qywxDeptUser.setUserId(178L);
        qYWXDeptUserService.insertQYWXDeptUser(qywxDeptUser);
    }

}
