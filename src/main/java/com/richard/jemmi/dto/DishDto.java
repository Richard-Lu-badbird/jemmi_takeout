package com.richard.jemmi.dto;

import com.richard.jemmi.entity.Dish;
import com.richard.jemmi.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//Data Transfer Object
@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
