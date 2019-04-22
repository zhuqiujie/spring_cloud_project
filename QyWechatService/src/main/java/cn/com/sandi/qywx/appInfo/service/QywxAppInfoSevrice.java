package cn.com.sandi.qywx.appInfo.service;

import cn.com.sandi.qywx.appInfo.model.QywxAppInfo;

public interface QywxAppInfoSevrice {

    public QywxAppInfo getAppInfoByAgentIdAndCorpId(String agentId,String corpId);
}
