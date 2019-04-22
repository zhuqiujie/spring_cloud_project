package cn.com.sandi.qywx.service.systemService;

import cn.com.sandi.qywx.message.model.QywxSendText;
import cn.com.sandi.qywx.message.model.Text;
import cn.com.sandi.qywx.system.service.SendDataToQywxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendDataToQywxServiceTest {

    @Autowired
    private SendDataToQywxService sendDataToQywxService;
    @Test
    public void sendMessage() {

        /**
         *touser、toparty、totag不能同时为空
         {
         "touser" : "UserID1|UserID2|UserID3",
         "toparty" : "PartyID1|PartyID2",
         "totag" : "TagID1 | TagID2",
         "msgtype" : "text",
         "agentid" : 1,
         "text" : {
             "content" : "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。"
             },
         "safe":0
         }
         */

        String content = "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。";

        String content1 = "发给自己";


        String corpId = "wwd6a6821842f0746c";
        String agentId = "1000004";//集福活动

        QywxSendText qywxSendText = new QywxSendText();
        Text text = new Text();
        text.setContent(content1);


        qywxSendText.setAgentid(Long.parseLong(agentId));
        //qywxSendText.setTouser("@all");
        qywxSendText.setTouser("QiuXinChou");
        qywxSendText.setMsgtype("text");
        //qywxSendText.setToparty("2");
        qywxSendText.setSafe(0);
        qywxSendText.setText(text);

        sendDataToQywxService.sendMessage(corpId,agentId, qywxSendText);

    }
}