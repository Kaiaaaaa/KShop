package com.kaia.kshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kaia.kshop.entity.Commodit;
import com.kaia.kshop.entity.Result;
import com.kaia.kshop.mapper.CommoditMapper;
import com.kaia.kshop.service.CommoditService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaia
 * @since 2022-05-27
 */
@RestController
@RequestMapping("/kshop/commodit")
public class CommoditController {

    @Autowired
    private CommoditMapper commoditMapper;

    @Autowired

    private CommoditService commoditService;

    @GetMapping("/goumai/{id}")
    public Result goumai(@PathVariable("id")Integer id){
        Commodit commodit = commoditMapper.selectById(id);
        if(commodit.getCommoditNum()>0){
            commoditMapper.goumai(id);
        }
        return Result.ok();
    }
}

