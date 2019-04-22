package cn.com.sandi.qywx.user.service;

import cn.com.sandi.qywx.user.model.QywxUser;

public interface QywxUserService {

    public QywxUser getUserByCorpIdAndCorpUserId(String corpId,String corpUserId);

    public QywxUser saveQywxUser(QywxUser qywxUser);

}
