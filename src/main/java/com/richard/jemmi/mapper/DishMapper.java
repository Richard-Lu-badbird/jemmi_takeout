package com.richard.jemmi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.richard.jemmi.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
