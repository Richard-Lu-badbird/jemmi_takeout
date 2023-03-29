package com.richard.jemmi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.richard.jemmi.entity.Dish;
import com.richard.jemmi.entity.DishFlavor;
import com.richard.jemmi.mapper.DishFlavorMapper;
import com.richard.jemmi.service.DishFlavorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
