package cn.com.sandi.qywx.system.service;

import cn.com.sandi.qywx.message.model.QywxBaseMsg;
import net.sf.json.JSONObject;

public interface SendDataToQywxService {
    public JSONObject sendMessage(String corpId, String agentId, QywxBaseMsg message);

}
