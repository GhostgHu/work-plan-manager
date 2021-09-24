package com.shimengjie.wpm.authority.domain.model.commonauthority;

/**
 * @author shimengjie
 * @date 2021/9/23 17:54
 **/
public interface ICommonAuthConstant {

    /**
     * operateType 字段含义
     */
    interface OperateType {
        // 是否能发布评论
        String COMMENT = "comment";
        // 是否能修改用户信息
        String CHANGE_USER_INFO = "changeUserInfo";
    }
}
