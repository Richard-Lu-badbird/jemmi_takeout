package com.richard.jemmi.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.richard.jemmi.common.R;
import com.richard.jemmi.entity.Category;
import com.richard.jemmi.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Category category) {
        log.info("category: {}", category);
        categoryService.save(category);
        return R.success("添加成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
        log.info("page:{}, pageSize:{}", page, pageSize);
        //构造分页面处理器
        Page<Category> pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();

        //添加过滤条件(排序的条件sortBySort字段)
        queryWrapper.orderByAsc(Category::getSort);
        categoryService.page(pageInfo);
        return R.success(pageInfo);
    }


    /**
     * 删除菜品信息
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long id) {

//        这里调用的是mybatis的remove方法
//        categoryService.removeById(id);
//        这里使用自定义的categoryService中的remove方法
        categoryService.remove(id);
        return R.success("分类信息删除成功");

    }

    /**
     * 根据id修改信息
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        log.info("category: {}", category);
        categoryService.updateById(category);
        return R.success("修改分类信息成功");
    }

    @GetMapping("/list")
    public R<List<Category>> get(Category category) {
        log.info("category: {}", category.toString());
        //条件构造器
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        lambdaQueryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = categoryService.list(lambdaQueryWrapper);
        return R.success(list);

    }

//    @GetMapping("/list")
//    public R<List<Category>> get(int type) {
//        log.info("type is:{}", type);
//        return null;
//    }

    //总结：@RequestBody用于对象映射，@PathVariable 用于/book/1这种，@PathParam用于/book?type=1&name=nm



}
