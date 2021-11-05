package com.shimengjie.wpm.app.application.work;

import com.shimengjie.wpm.app.port.adapter.work.WorkAdapter;
import com.shimengjie.wpm.common.response.AbstractResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 17:55
 **/
@Slf4j
@RestController
@RequestMapping(value = "api/wpm/app/work", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WorkController {

    @Resource
    private WorkAdapter workAdapter;


    @ApiOperation("分页查询活动作品")
    @PostMapping("/like/{type}/{id}")
    public AbstractResponse likeWork(@PathVariable("type") String type,
                                     @PathVariable("id") Long id) {
        workAdapter.like(type, id);
        return new AbstractResponse();
    }
}
