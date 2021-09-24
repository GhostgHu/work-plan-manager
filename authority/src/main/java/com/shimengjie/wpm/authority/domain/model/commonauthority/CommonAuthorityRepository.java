package com.shimengjie.wpm.authority.domain.model.commonauthority;

/**
 * @author shimengjie
 * @date 2021/9/23 20:15
 **/
public interface CommonAuthorityRepository {

    /**
     * 根据 operateType 查询 CommonAuthority
     *
     * @param operateType operateType
     * @return CommonAuthority
     */
    CommonAuthority queryOfOperateType(String operateType);
}
