package cn.com.sandi.qywx.appInfo.service.impl;

import cn.com.sandi.qywx.appInfo.model.QywxAppInfo;
import cn.com.sandi.qywx.appInfo.service.QywxAppInfoSevrice;
import cn.com.sandi.qywx.base.jpa.dao.GenericDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("qywxAppInfoSevrice")
public class QywxAppInfoSevriceImpl implements QywxAppInfoSevrice{


    @Resource
    private GenericDao<QywxAppInfo, Long> qywxAppInfoDao;

    @Override
    public QywxAppInfo getAppInfoByAgentIdAndCorpId(String agentId,String corpId) {

        if(StringUtils.isBlank(agentId) || StringUtils.isBlank(corpId)){
            return null;
        }


        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put("corpId",corpId);

        paraMap.put("agentId",agentId);

       List<QywxAppInfo> appInfos = qywxAppInfoDao.findByWhere("AGENT_ID=:agentId AND CORP_ID=:corpId",paraMap,0,0);

       if(appInfos.size()>0){
           return appInfos.get(0);
       }
        return null;
    }
}
