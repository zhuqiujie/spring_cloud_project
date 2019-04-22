package cn.com.sandi.qywx.service.systemService;


import cn.com.sandi.qywx.message.model.QywxSendText;
import cn.com.sandi.qywx.message.model.QywxSendTextCard;
import cn.com.sandi.qywx.message.model.Text;
import cn.com.sandi.qywx.message.model.Textcard;
import cn.com.sandi.qywx.system.service.QywxOpenService;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QywxOpenServiceTest {

    @Autowired
    private QywxOpenService qywxOpenService;
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
             "content" : "你的快递11已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。"
             },
             "safe":0
             }
             */

            String content = "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。";

            String content2 = "发给自己";


            String corpId = "wwd6a6821842f0746c";
            String agentId = "1000004";//集福活动1

            QywxSendText qywxSendText = new QywxSendText();
            Text text = new Text();
            text.setContent(content2);


            qywxSendText.setAgentid(Long.parseLong(agentId));
            //qywxSendText.setTouser("@all");
            qywxSendText.setTouser("QiuXinChou");
            qywxSendText.setMsgtype("text");
            //qywxSendText.setToparty("2");
            qywxSendText.setSafe(0);
            qywxSendText.setText(text);

        qywxOpenService.sendTextToQywx(corpId,agentId, JSONObject.fromObject(qywxSendText).toString());

        }


    @Test
    public void sendTextCardToQywx() {

        String corpId = "wwd6a6821842f0746c";
        String agentId = "1000004";//集福活动1

        //0.设置消息内容
        String title="代办事宜";
        String description="<div class=\"gray\">2017年8月18日</div> <div class=\"normal\">" +
                "恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">" +
                "请于2017年10月10日前联系行政同事领取</div>";
        String url="http://www.cnblogs.com/shirui/p/7297872.html";

        Textcard textcard = new Textcard();
        textcard.setDescription(description);
        textcard.setTitle(title);
        textcard.setUrl(url);

        QywxSendTextCard message = new QywxSendTextCard();

        message.setAgentid(Long.parseLong(agentId));
        message.setMsgtype("textcard");
        //message.setToparty("2");
        //message.setTouser("@all");
        message.setTouser("QiuXinChou");

        message.setTextcard(textcard);

        String sendStr = JSONObject.fromObject(message).toString();

        qywxOpenService.sendTextCardToQywx(corpId,agentId,sendStr);
    }
}