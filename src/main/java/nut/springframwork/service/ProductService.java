package nut.springframwork.service;

import nut.springframwork.domain.Product;

import java.util.List;

/**
 * Created by NUT_PC on 02/04/2560.
 */
public interface ProductService {

    List<Product> listAllProduct();
    Product getProductById(Integer id);
    Product saveOrUpdateProduct(Product product);
    void deleteProduct(Integer id);
}
