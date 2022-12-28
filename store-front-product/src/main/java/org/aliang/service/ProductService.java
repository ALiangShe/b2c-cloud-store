package org.aliang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.aliang.param.ProductHotParam;
import org.aliang.param.ProductIdsParam;
import org.aliang.param.ProductPromoParam;
import org.aliang.pojo.Product;
import org.aliang.utils.R;

public interface ProductService extends IService<Product> {

    /**
     * 根据类别名称查询热门产品
     * @param categoryName 类别名称
     * @return
     */
    R promo(String categoryName);

    /**
     * 根据类别集合查询热门产品
     * @param productHotParam
     * @return
     */
    R hots(ProductHotParam productHotParam);

    /**
     * 查询商品类别集合
     * @return
     */
    R getCategoryList();

    /**
     * 类别商品接口
     * @param productIdsParam
     * @return
     */
    R byCategory(ProductIdsParam productIdsParam);

    /**
     * 根据商品id查询商品详情
     * @param productID 商品id 已校验
     * @return
     */
    R detail(Integer productID);

    /**
     * 根据商品id查询商品的图片
     * @param productID
     * @return
     */
    R pictures(Integer productID);
}
