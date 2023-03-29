package com.richard.jemmi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.richard.jemmi.entity.Employee;
import com.richard.jemmi.mapper.EmployeeMapper;
import com.richard.jemmi.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
