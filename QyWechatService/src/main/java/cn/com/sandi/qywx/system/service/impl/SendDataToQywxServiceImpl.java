package cn.com.sandi.qywx.system.service.impl;

import cn.com.sandi.qywx.base.utils.QywxHttpUtils;
import cn.com.sandi.qywx.base.utils.UrlsConstants;
import cn.com.sandi.qywx.message.model.QywxBaseMsg;
import cn.com.sandi.qywx.system.service.SendDataToQywxService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sendDataToQywxService")
public class SendDataToQywxServiceImpl implements SendDataToQywxService{

    private static Logger logger = (Logger) LoggerFactory.getLogger(SendDataToQywxServiceImpl.class);

    @Autowired
    private GetDataFromQywxServiceImpl getDataFromQywxService;

    /**
     * 发送消息
     * @param corpId
     * @param agentId
     * @param message
     */
    public JSONObject sendMessage(String corpId, String agentId,QywxBaseMsg message){


        //0.获取 accessToken
        String accessToken = getDataFromQywxService.getQywxToken(corpId,agentId);


        //1.获取json字符串：将message对象转换为json字符串
        JSONObject jsonMsg = JSONObject.fromObject(message);


        String jsonMessage =jsonMsg.toString();      //使用gson.toJson(user)即可将user对象顺序转成json
        logger.info("jsonTextMessage:"+jsonMessage);


        //2.获取请求的url
       String sendMsgUrl = UrlsConstants.SEND_MSG_URL.replace(UrlsConstants.SEND_MSG_REPLACE_KEY, accessToken);

        //3.调用接口，发送消息
        JSONObject jsonObject = QywxHttpUtils.httpRequest(sendMsgUrl, "POST", jsonMessage);
        logger.info("jsonObject:"+jsonObject.toString());

//        //4.错误消息处理
//        if (null != jsonObject) {
//            if (0 != jsonObject.getInt("errcode")) {
//                logger.error("发送消息失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
//            }
//        }

        return jsonObject;
    }

}
