package product.com.product_management.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.com.product_management.model.Product;
import product.com.product_management.repository.IProductRepository;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public Product remove(Long id) {
         iProductRepository.deleteById(id);
        return null;
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);

    }
}
