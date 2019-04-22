package cn.com.sandi.qywx.system.service.impl;

import cn.com.sandi.qywx.message.model.QywxSendText;
import cn.com.sandi.qywx.message.model.QywxSendTextCard;
import cn.com.sandi.qywx.system.service.QywxOpenService;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("qywxOpenService")
public class QywxOpenServiceImpl implements QywxOpenService{

    private static Logger logger = (Logger) LoggerFactory.getLogger(QywxOpenServiceImpl.class);

    @Autowired
    private InitDataToDBServiceImpl initDataToDBService;
    @Autowired
    private GetDataFromQywxServiceImpl getDataFromQywxService;

    @Autowired
    private SendDataToQywxServiceImpl sendDataToQywxService;

    public String getUserIdFromQywx(String corpId,String agentId,String code){
        String jsonStr = getDataFromQywxService.getUserInfoFromQywx(corpId,agentId,code);

        Map<String, Object> map = JSON.parseObject(jsonStr);

        String errcode = map.get("errcode").toString();

        if(!errcode.equals("0")){
            String errmsg = map.get("errmsg").toString();
            logger.info("QywxOpenService==>getUserIdFromQywex");
            logger.info("获取userInfo失败！errcode："+errcode+"=====errmsg:"+errmsg);
            return "0";
        }

        logger.info("获取userInfo成功++++"+map.get("UserId").toString());

        return map.get("UserId").toString();
    }

    /**
     * 发送文本消息
     * @param corpId
     * @param agentId
     * @param msgJson
     * @return
     */
    public JSONObject sendTextToQywx(String corpId, String agentId,String msgJson){
        logger.info("corpId:"+corpId+"  agentId:"+agentId+"\r\n    msgJson:"+msgJson);
        JSONObject mesgJson = JSONObject.fromObject(msgJson);
        QywxSendText qywxSendText = (QywxSendText)JSONObject.toBean(mesgJson,QywxSendText.class);
        JSONObject jsonObject = sendDataToQywxService.sendMessage(corpId,agentId,qywxSendText);
        logger.info(jsonObject.toString());
        //4.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                logger.error("发送消息失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }

        return jsonObject;
    }

    /**
     * 发送文本卡片消息
     * @param corpId
     * @param agentId
     * @param msgJson
     * @return
     */
    public JSONObject sendTextCardToQywx(String corpId, String agentId, String msgJson){
        logger.info("corpId:"+corpId+"  agentId:"+agentId+"\r\n    msgJson:"+msgJson);
        JSONObject json = JSONObject.fromObject(msgJson);
        QywxSendTextCard sendTextCard = (QywxSendTextCard)JSONObject.toBean(json,QywxSendTextCard.class);

        JSONObject jsonObject = sendDataToQywxService.sendMessage(corpId,agentId,sendTextCard);

        logger.info(jsonObject.toString());
        //4.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                logger.error("发送文本卡片消息失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }

        return jsonObject;
    }


    @Override
    public JSONObject initDeptUserList(String corpId, String agentId) {
        logger.info("corpId:"+corpId+"  agentId:"+agentId);
        Map<String,String> returnMap = new HashMap<>();

        try {

            String jsonStr = getDataFromQywxService.getDeptByAgentIdFromQywx(corpId,agentId,null);

            Map<String, Object> map = JSON.parseObject(jsonStr);

            initDataToDBService.saveDeptUserList(corpId,agentId,map.get("department").toString());
            returnMap.put("errmsg","ok");
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("errmsg",e.getMessage());
        }
        JSONObject jsonObject = JSONObject.fromObject(returnMap);

        return jsonObject;
    }
}
