package cn.com.sandi.qywx.system.controller;

import ch.qos.logback.classic.Logger;
import cn.com.sandi.qywx.system.service.QywxOpenService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/qywx")
public class TestQywxController {
    private static Logger logger = (Logger) LoggerFactory.getLogger(TestQywxController.class);

    @Autowired
    private QywxOpenService qywxOpenService;

    @RequestMapping("/testQywx")
    public String testQywx(@RequestParam("code")String code,@RequestParam("state")String state,Model model){
        //logger.info("访问成功");

        logger.info("code:"+code+"\r\n"+"state:"+state);
        model.addAttribute("code",code);
        //将code写进redis，5min过期


        return "getToken";
    }

    @RequestMapping("/showUserId")
    public String showUserId(HttpServletRequest req, Model model) {
       String corpId =  req.getParameter("corpId").trim();
       String agentId = req.getParameter("agentId").trim();
       String code = req.getParameter("code");


       String userId = qywxOpenService.getUserIdFromQywx(corpId,agentId,code);

        if(userId.equals("0")){
            userId = "获取userid失败,可能时间超时";
        }

       model.addAttribute("userId",userId);
       return "userIdView";
    }


}

