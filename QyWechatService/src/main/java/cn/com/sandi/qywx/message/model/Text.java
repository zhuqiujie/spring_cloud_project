package cn.com.sandi.qywx.message.model;

import java.io.Serializable;

public class Text implements Serializable{

    //消息内容，最长不超过2048个字节
    private String content;

    public Text() {
    }

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
