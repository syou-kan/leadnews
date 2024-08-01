package com.heima.user.service.Impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.utils.common.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.LoginDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApuserMapper;
import com.heima.user.service.ApUserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import java.util.HashMap;
import java.util.Map;
@Service
public class ApUserServiceImpl extends ServiceImpl<ApuserMapper, ApUser> implements ApUserService {

    @Override
    public ResponseResult loginAuth(LoginDto dto) {
        //1.正常登录（手机号+密码登录）
        if (StringUtils.isNotBlank(dto.getPhone())&& StringUtils.isNotBlank(dto.getPassword())){
            //1.2 根据手机号码判断
            ApUser apUser=getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone,dto.getPhone()));
            if (apUser==null){
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户不存在");
            }
            //1.3 根据密码判断
            String pswd = DigestUtils.md5DigestAsHex((dto.getPassword() + apUser.getSalt()).getBytes());
            if (!apUser.getPassword().equals(pswd)){
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
            //1.4编写JWT
            Map<String,Object> mapper =new HashMap();
            mapper.put("token", AppJwtUtil.getToken(apUser.getId().longValue()));
            apUser.setSalt("");
            apUser.setPassword("");
             mapper.put("user", apUser);

            return ResponseResult.okResult(mapper);
        }else {
             //2.游客  同样返回token  id = 0
            Map<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0l));
            return ResponseResult.okResult(map);
        }
    }
}
