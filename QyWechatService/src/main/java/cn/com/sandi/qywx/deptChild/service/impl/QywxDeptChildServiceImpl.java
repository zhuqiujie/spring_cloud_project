package cn.com.sandi.qywx.deptChild.service.impl;

import cn.com.sandi.qywx.base.jpa.dao.GenericDao;
import cn.com.sandi.qywx.deptChild.model.QywxDeptChild;
import cn.com.sandi.qywx.deptChild.service.QywxDeptChildService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("qywxDeptChildService")
public class QywxDeptChildServiceImpl implements QywxDeptChildService{

    @Resource
    private GenericDao<QywxDeptChild, Long> qywxDeptChildDao;

    /**
     * 每次对树结构有改动时都要重新建立一颗树
     * @param corpId
     */
    @Override
    public void deleteDeptChildByCorpId(String corpId) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("corpId",corpId);
        qywxDeptChildDao.deleteByWhere("CORP_ID=:corpId",paramMap);
    }

    @Override
    public QywxDeptChild saveQywxDeptChild(QywxDeptChild qywxDeptChild) {
        QywxDeptChild qywxDeptChildDB = qywxDeptChildDao.save(qywxDeptChild);
        return qywxDeptChildDB;
    }
}
