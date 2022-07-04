package com.kaia.kshop.mapper;

import com.kaia.kshop.entity.Commodit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaia.kshop.entity.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaia
 * @since 2022-05-27
 */
@Repository
public interface CommoditMapper extends BaseMapper<Commodit> {
    Integer goumai(@Param("id") Integer id);
}
