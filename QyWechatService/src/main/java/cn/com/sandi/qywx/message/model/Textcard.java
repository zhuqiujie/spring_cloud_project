package cn.com.sandi.qywx.message.model;

import java.io.Serializable;

public class Textcard implements Serializable{

    //是 标题，不超过128个字节，超过会自动截断
    private String title;
    //是    描述，不超过512个字节，超过会自动截断
    private String description;
    //是    点击后跳转的链接。
    private String url;

    //btntxt    否    按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断。

    public Textcard(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public Textcard() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
