package product.com.product_management.service.category;

import product.com.product_management.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);

}
