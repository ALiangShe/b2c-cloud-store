package org.aliang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aliang.mapper.CategoryMapper;
import org.aliang.param.ProductHotParam;
import org.aliang.pojo.Category;
import org.aliang.service.CategoryService;
import org.aliang.utils.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 根据类别名称查询类别并封装返回
     *
     * @param categoryName 类别名称
     * @return
     */
    @Override
    public R byName(String categoryName) {
        //1.参数校验
        if (StringUtils.isBlank(categoryName)){
            return R.fail("参数异常！查询失败！");
        }
        //2.查询数据库
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Category::getCategoryName,categoryName);
        Category category = categoryMapper.selectOne(lambdaQueryWrapper);
        if (category == null){
            log.info("org.aliang.service.impl.CategoryServiceImpl.byName()业务方法结束，查询类别:={}=没有数据",categoryName);
            return R.fail("查询的类别不存在！");
        }
        log.info("org.aliang.service.impl.CategoryServiceImpl.byName()业务方法结束，查询类别:={}=成功",categoryName);
        return R.ok(category);
    }

    /**
     * 根据传入的热门类别名称集合！返回类别对应的id集合
     *
     * @param productHotParam 类别名称集合 已校验
     * @return
     */
    @Override
    public R hots(ProductHotParam productHotParam) {
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(Category::getCategoryName,productHotParam.getCategoryName());
        lambdaQueryWrapper.select(Category::getCategoryId);
        List<Object> idList = categoryMapper.selectObjs(lambdaQueryWrapper);
        if (idList == null || idList.size() == 0){
            return R.fail("查询失败!");
        }
        log.info("org.aliang.service.impl.CategoryServiceImpl.hots()业务方法执行完毕，结果为：{}","查询成功");
        return R.ok("类别集合id查询成功",idList);
    }
}