package org.aliang.service;


import org.aliang.param.ProductSearchParam;
import org.aliang.pojo.Product;
import org.aliang.utils.R;

import java.io.IOException;

public interface SearchService {

    /**
     * ๅๅๆ็ดข
     * @param productSearchParam
     * @return
     */
    R searchProduct(ProductSearchParam productSearchParam);

    R save(Product product) throws IOException;

    R remove(Integer productId) throws IOException;
}
