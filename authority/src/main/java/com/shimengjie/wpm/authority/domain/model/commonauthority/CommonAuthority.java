package com.shimengjie.wpm.authority.domain.model.commonauthority;

import java.time.LocalDateTime;

/**
 * @author shimengjie
 * @date 2021/9/23 18:52
 **/
public class CommonAuthority {

    private Long id;

    private String operateType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public CommonAuthority() {
    }

    public CommonAuthority(String operateType) {
        this.operateType = operateType;
    }

    /**
     * 是否允许
     *
     * @return true / false
     */
    public boolean isAllow() {
        LocalDateTime now = LocalDateTime.now();
        return now.isBefore(this.startTime) || now.isAfter(this.endTime);
    }
}
