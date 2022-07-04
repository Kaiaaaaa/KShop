package com.kaia.kshop.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result implements Serializable {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    //私有化构造方法
    private Result() {}

    //成功静态方法
    public static Result ok(){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("成功");
        return r;
    }
    //失败静态方法
    public static Result error(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(400);
        r.setMessage("失败");
        return r;
    }

    /** return this ,是为了链式编程 **/
    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public Result message(String message){
        this.setMessage(message);
        return this;
    }
    public Result code(Integer code){
        this.setCode(code);
        return this;
    }
    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
