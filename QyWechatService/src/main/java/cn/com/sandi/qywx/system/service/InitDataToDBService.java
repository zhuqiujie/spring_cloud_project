package cn.com.sandi.qywx.system.service;

/**
 * 将从企业微信拿到的数据写库
 *
 */
public interface InitDataToDBService {

    public void saveDeptUserList(String corpId, String agentId, String deptListStr);

    public void saveUserList(String corpId, String agentId, Long cordDeptId, Integer fetchChild);


}
