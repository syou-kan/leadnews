package com.heima.model.user.dtos;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.Value;

@Data
public class LoginDto {
    /*
    * 手机号
    * */
    @ApiModelProperty(value="手机号",required=true)
    private String phone;
    /*
    * 密码
    */
    @ApiModelProperty(value = "密码",required=true)
    private  String password;
}
