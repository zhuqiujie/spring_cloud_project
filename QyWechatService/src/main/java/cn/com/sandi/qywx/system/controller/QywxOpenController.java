package cn.com.sandi.qywx.system.controller;

import cn.com.sandi.qywx.system.service.QywxOpenService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/qywx/api/qywxOpenService")
public class QywxOpenController {


    @Resource
    private QywxOpenService qywxOpenService;


    @RequestMapping("/getUserIdFromQywx")
    public String getUserIdFromQywx(@RequestParam("corpId") String corpId, @RequestParam("agentId") String agentId, @RequestParam("code") String code){

        String returnStr = qywxOpenService.getUserIdFromQywx(corpId,agentId,code);
        return returnStr;
    }

    @RequestMapping("/sendTextToQywx")
    public JSONObject sendTextToQywx(@RequestParam("corpId") String corpId, @RequestParam("agentId") String agentId, @RequestParam("msgJson") String msgJson){
        JSONObject returnJson = qywxOpenService.sendTextToQywx(corpId,agentId,msgJson);
        return returnJson;
    }


    @RequestMapping("sendTextCardToQywx")
    public JSONObject sendTextCardToQywx(@RequestParam("corpId") String corpId, @RequestParam("agentId") String agentId, @RequestParam("msgJson") String msgJson){
        JSONObject returnJson = qywxOpenService.sendTextCardToQywx(corpId,agentId,msgJson);

        return returnJson;
    }

    @RequestMapping("initDeptUserList")
    public JSONObject initDeptUserList(@RequestParam("corpId") String corpId, @RequestParam("agentId") String agentId){
        JSONObject returnJson = qywxOpenService.initDeptUserList(corpId,agentId);
        return returnJson;
    }

}
