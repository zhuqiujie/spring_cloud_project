package cn.com.sandi.qywx.message.model;

public class QywxSendTextCard extends QywxBaseMsg {

    //文本
    private Textcard textcard;

    public Textcard getTextcard() {
        return textcard;
    }

    public void setTextcard(Textcard textcard) {
        this.textcard = textcard;
    }
}
