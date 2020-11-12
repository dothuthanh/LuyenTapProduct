package product.com.product_management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    @ManyToOne
    @JoinColumn(name = "category_id")
//    , referencedColumnName = "id", nullable = false
    private Category category;

}
