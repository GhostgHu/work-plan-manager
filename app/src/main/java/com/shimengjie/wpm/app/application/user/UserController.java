package com.shimengjie.wpm.app.application.user;


import com.shimengjie.wpm.app.port.adapter.user.UserAdapter;
import com.shimengjie.wpm.authority.domain.model.commonauthority.ICommonAuthConstant;
import com.shimengjie.wpm.authority.domain.model.commonauthority.annotation.EnableCommonAuthority;
import com.shimengjie.wpm.common.response.AbstractResponse;
import com.shimengjie.wpm.common.response.Response;
import com.shimengjie.wpm.user.domain.model.user.User;
import com.shimengjie.wpm.user.domain.model.user.command.UserUpdateCommand;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/9/22 17:38
 **/
@Slf4j
@RestController
@RequestMapping(value = "api/wpm/app/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Resource
    private UserAdapter userAdapter;

    @ApiOperation("更新用户信息")
    @PutMapping("/{id}")
    @EnableCommonAuthority(operateType = ICommonAuthConstant.OperateType.CHANGE_USER_INFO)
    public AbstractResponse updateById(@PathVariable("id") Long id, @RequestBody UserUpdateCommand command) {
        userAdapter.updateById(id, command);
        return new AbstractResponse();
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/{id}")
    public Response<User> queryById(@PathVariable("id") Long id) {
        User user = userAdapter.queryById(id);
        return Response.ofSuccess(user);
    }

}
