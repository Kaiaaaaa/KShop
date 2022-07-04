package com.kaia.kshop.entity.Vo;

import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    private Integer id;
    private String username;
    private String nickname;
    private Integer account;

}
