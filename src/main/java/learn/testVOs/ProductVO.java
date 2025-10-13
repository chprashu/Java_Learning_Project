package learn.testVOs;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "product")
@Entity
@Getter
@Setter
public class ProductVO extends BaseVO{
    private String productId;
    private String productName;
    private String style;
    private String color;
    private String category;
    private String brand;
    private double rating;
    private double retailPrice;
    private double actualPrice;
    private String currency;
    private String image;
}
