package com.heima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.LoginDto;
import com.heima.model.user.pojos.ApUser;
import org.springframework.stereotype.Service;

@Service
public interface ApUserService extends IService<ApUser> {
    /*
    * app用户登录
    *@param dto
    *@return
    * */
    public ResponseResult loginAuth(LoginDto dto);
}
