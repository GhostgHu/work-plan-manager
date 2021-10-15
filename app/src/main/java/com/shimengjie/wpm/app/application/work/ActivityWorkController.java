package com.shimengjie.wpm.app.application.work;

import com.shimengjie.wpm.app.port.adapter.work.ActivityWorkAdapter;
import com.shimengjie.wpm.common.response.PageResponse;
import com.shimengjie.wpm.work.domain.model.activity.ActivityWork;
import com.shimengjie.wpm.work.domain.model.activity.ActivityWorkListEntity;
import com.shimengjie.wpm.work.domain.model.activity.query.ActivityWorkListQuery;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/10/14 21:29
 **/
@Slf4j
@RestController
@RequestMapping(value = "api/wpm/app/activity_work", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ActivityWorkController {

    @Resource
    private ActivityWorkAdapter activityWorkAdapter;

    @ApiOperation("分页查询活动作品")
    @GetMapping("/works")
    public PageResponse<ActivityWork> queryActivityWorkList(@RequestParam(value = "title", required = false) String title,
                                                            @RequestParam(value = "seed", defaultValue = "0") Integer seed,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        ActivityWorkListQuery query = new ActivityWorkListQuery(title, seed, pageNum, pageSize);
        ActivityWorkListEntity entity = activityWorkAdapter.queryActivityWorkList(query);
        return new PageResponse<>(entity.getTotal(), query.getPageSize(), query.getSeed(), entity.getActivityWorkList());
    }
}
