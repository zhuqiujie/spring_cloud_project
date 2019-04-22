package cn.com.sandi.qywx.corpInfo.service.impl;

import cn.com.sandi.qywx.base.jpa.dao.GenericDao;
import cn.com.sandi.qywx.corpInfo.model.QywxCorpInfo;
import cn.com.sandi.qywx.corpInfo.service.QywxCorpInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("qywxCorpInfoService")
public class QywxCorpInfoServiceImpl implements QywxCorpInfoService{

    @Resource
    private GenericDao<QywxCorpInfo, Long> qywxCorpInfoDao;


    @Override
    public Long getTenIdByCorpId(String corpId) {
        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put("corpId",corpId);

        List<QywxCorpInfo> corpInfos = qywxCorpInfoDao.findByWhere("CORP_ID=:corpId",paraMap,0,0);

        if(corpInfos == null || corpInfos.size() <= 0){
            return null;
        }

        return corpInfos.get(0).getTenantsId();
    }

    @Override
    public Long getOrgIdByCorpId(String corpId) {
        Map<String,Object> paraMap = new HashMap<>();

        paraMap.put("corpId",corpId);

        List<QywxCorpInfo> corpInfos = qywxCorpInfoDao.findByWhere("CORP_ID=:corpId",paraMap,0,0);

        if(corpInfos == null || corpInfos.size() <= 0){
            return null;
        }

        return corpInfos.get(0).getOrganizerId();
    }
}
