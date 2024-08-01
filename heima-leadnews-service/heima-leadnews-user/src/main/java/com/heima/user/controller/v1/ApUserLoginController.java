package com.heima.user.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.LoginDto;
import com.heima.user.service.ApUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户登录模块", tags = "用户登录模块")
@RequestMapping("/api/v1/login")
public class ApUserLoginController {
    @Autowired
    private ApUserService apUserService;
    @PostMapping("/login_auth")
    @ApiOperation("app用户登录")
    public ResponseResult loginAuth(@RequestBody LoginDto dto) {
        return apUserService.loginAuth(dto);
    }

}
