package com.shimengjie.wpm.common.constantt;

/**
 * 返回的消息文案
 */
public interface IReturnMessage {
    /**
     * 成功
     */
    String OK = "ok";
    /**
     * 系统错误
     */
    String SYSTEM_ERROR = "error.system-error";
    /**
     * 参数错误
     */
    String PARAM_ERROR = "error.param-error";
    /**
     * 缺少参数
     */
    String PARAM_EMPTY = "error.param-empty";
    /**
     * 数据已存在
     */
    String DATA_EXIST = "error.data-exist";
    /**
     * 未登陆
     */
    String UNLOGGED = "error.un-logged";
    /**
     * 数据不存在
     */
    String DATA_NOT_EXIST = "error.data-not-exist";
    /**
     * 拒绝操作
     */
    String REFUSE = "error.refuse";
    /**
     * 意外的错误
     */
    String UNEXPECTED_TYPE = "#error.unexpected-ype";
    /**
     * 超时
     */
    String TIME_OUT = "error.time-out";
    /**
     * 登陆失败
     */
    String LOGIN_FAILURE = "error.login-failure";


}
