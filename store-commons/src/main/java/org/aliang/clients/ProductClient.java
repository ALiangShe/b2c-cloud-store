package org.aliang.clients;

import org.aliang.param.ProductCollectParam;
import org.aliang.param.ProductIdParam;
import org.aliang.param.ProductSaveParam;
import org.aliang.pojo.Product;
import org.aliang.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "product-service")
public interface ProductClient {

    /**
     * 搜索服务调用，进行全部数据查询！用于搜索数据库同步数据！
     * @return
     */
    @GetMapping("/product/list")
    List<Product> getProductList();

    @PostMapping("/product/collect/list")
    R getCollectList(@RequestBody ProductCollectParam productCollectParam);

    @PostMapping("/product/cart/detail")
    Product productDetail(@RequestBody ProductIdParam productIdParam);

    @PostMapping("/product/cart/list")
    List<Product> cartList(@RequestBody ProductCollectParam productCollectParam);

    @PostMapping("/product/admin/count")
    Long count(@RequestBody Integer categoryId);

    @PostMapping("/product/admin/save")
    R adminSave(@RequestBody ProductSaveParam productSaveParam);

    @PostMapping("/product/admin/update")
    R adminUpdate(@RequestBody Product product);

    @PostMapping("/product/admin/remove")
    R adminRemove(@RequestBody Integer productId);
}
