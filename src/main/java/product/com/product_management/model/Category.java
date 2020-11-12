package product.com.product_management.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @JoinColumn(unique = true)
    private String name;
//    @OneToMany(targetEntity = Product.class)
//    private Set<Product> products;
}
