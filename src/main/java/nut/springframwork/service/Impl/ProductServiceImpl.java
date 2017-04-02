package nut.springframwork.service.Impl;

import nut.springframwork.domain.Product;
import nut.springframwork.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by NUT_PC on 02/04/2560.
 */
@Service
public class ProductServiceImpl implements ProductService{

    private Map<Integer, Product> products;

    public ProductServiceImpl(){
        loadProduct();
    }

    @Override
    public List<Product> listAllProduct() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer id){
        return products.get(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product){
//        if (products.keySet() == null){
//            products.put(product.getId(), product);
//        }
        if (product != null){
            if (product.getId() == null){
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);

            return product;
        }else{
            throw new RuntimeException("Product Can't be nill");
        }
    }

    private Integer getNextKey(){
        return Collections.max(products.keySet()) +1 ;
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    private void loadProduct(){
        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDecription("Product 1");
        product1.setPrice(new BigDecimal("1.11"));
        product1.setImageUrl("image/1.jpg");

        products.put(1,product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDecription("Product 2");
        product2.setPrice(new BigDecimal("2.22"));
        product2.setImageUrl("image/2.jpg");

        products.put(2,product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setDecription("Product 3");
        product3.setPrice(new BigDecimal("3.33"));
        product3.setImageUrl("image/3.jpg");

        products.put(3,product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setDecription("Product 4");
        product4.setPrice(new BigDecimal("4.44"));
        product4.setImageUrl("image/4.jpg");

        products.put(4,product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setDecription("Product 5");
        product5.setPrice(new BigDecimal("5.55"));
        product5.setImageUrl("image/5.jpg");

        products.put(5,product5);
    }

}
