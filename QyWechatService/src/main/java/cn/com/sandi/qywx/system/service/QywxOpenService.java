package cn.com.sandi.qywx.system.service;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


public interface QywxOpenService {


    public String getUserIdFromQywx(String corpId, String agentId,String code);

    public JSONObject sendTextToQywx(String corpId, String agentId,  String msgJson);

    public JSONObject sendTextCardToQywx( String corpId,  String agentId, String msgJson);

    public JSONObject initDeptUserList( String corpId, String agentId);

}
