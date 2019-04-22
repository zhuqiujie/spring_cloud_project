package cn.com.sandi.qywx.service.impl;

import ch.qos.logback.classic.Logger;
import cn.com.sandi.qywx.dept.model.QywxDept;
import cn.com.sandi.qywx.dept.service.QywxDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QywxDeptServiceImplTest {

    private static Logger logger = (Logger) LoggerFactory.getLogger(QywxDeptServiceImplTest.class);

    @Autowired
    private QywxDeptService qywxDeptService;

    @Test
    public void getAllChildDept() {

        String corpId = "wwd6a6821842f0746c";
        Long parentId = 6L;
        List<QywxDept> qywxDeptList = new ArrayList<>();
        List<QywxDept> qywxDepts = qywxDeptService.getAllChildDept(corpId,parentId,qywxDeptList);
        logger.info(qywxDepts.toString());
    }
}