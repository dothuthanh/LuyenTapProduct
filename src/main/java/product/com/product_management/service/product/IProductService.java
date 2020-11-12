package product.com.product_management.service.product;

import product.com.product_management.model.Product;

public interface IProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
    Product remove(Long id);
    void save(Product product);



}
