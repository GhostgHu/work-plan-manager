package com.shimengjie.wpm.common.constantt;

/**
 * 返回值
 *
 * @author shimengjie
 */
public interface IReturnCode {
    /**
     * 系统错误
     */
    int SYSTEM_ERROR = 0;
    /**
     * 成功
     */
    int OK = 1;
    /**
     * 未登陆
     */
    int UN_LOGGED = 4001;
    /**
     * 无权限操作
     */
    int REFUSE = 4003;
    /**
     * 数据不存在
     */
    int DATA_NOT_EXIST = 4004;
    /**
     * 数据已存在
     */
    int DATA_EXIST = 4005;
    /**
     * 参数错误
     */
    int PARAM_ERROR = 4006;
    /**
     * CSRF TOKEN 无效
     */
    int CSRF_TOKEN_ERROR = 4007;
    /**
     * 第三方服务调用失败
     */
    int CLIENT_SERVER_ERROR = 4008;
}
