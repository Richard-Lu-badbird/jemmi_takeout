package com.richard.jemmi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.richard.jemmi.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
