package product.com.product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.com.product_management.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
