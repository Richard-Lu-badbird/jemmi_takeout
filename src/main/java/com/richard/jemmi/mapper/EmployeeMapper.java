package com.richard.jemmi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.richard.jemmi.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
