package cn.com.sandi.qywx.base.utils;

public class UrlsConstants {

    public static final String ACCESS_TOKEN = "access_token";


    //获取access_token
    public static final String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    public static final String ACCESS_TOKEN_URL_CORPID = "corpid";
    public static final String ACCESS_TOKEN_URL_CORPSECRET = "corpsecret";


    //获取部门成员
    public static final String GET_USER_BYDEPTID_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist";
    //获取部门成员详情
    public static final String GET_USERDETAIL_BYDEPTID_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/list";
    public static final String GET_USER_BYDEPTID_DEPARTMENT_ID = "department_id";
    public static final String GET_USER_BYDEPTID_FETCH_CHILD = "fetch_child";

    //获取部门列表
    public static final String GET_DEPTLIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list";

    public static final String GET_DEPTLIST_ID = "id";

    //根据code获取成员信息
    public static final String GET_USERINFO_BYCODE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";
    public static final String GET_USERINFO_BYCODE_CODE = "code";

    //发送应用消息
    public static final String SEND_MSG_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
    public static final String SEND_MSG_REPLACE_KEY = "ACCESS_TOKEN";

}
