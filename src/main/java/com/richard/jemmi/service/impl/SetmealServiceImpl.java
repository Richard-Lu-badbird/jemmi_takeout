package com.richard.jemmi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.richard.jemmi.entity.Setmeal;
import com.richard.jemmi.mapper.SetmealMapper;
import com.richard.jemmi.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
