package cn.com.sandi.qywx.system.service;

public interface GetDataFromQywxService {
    public String getQywxToken(String corpId, String agentId);

    public String getDeptByAgentIdFromQywx(String corpId,String agentId,String id);

    public String getUserByCorpIdFromQywx(String corpId,String agentId,Long corpDeptId,Integer fetchChild);

    public String getUserInfoFromQywx(String corpId,String agentId,String code);

}
