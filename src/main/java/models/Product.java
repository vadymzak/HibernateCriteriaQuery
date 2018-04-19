package models;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name="product")
public class Product extends Model {

    private static final long serialVersionUID = -7881391014358935700L;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    public Product(){
        super();
    }
    public Product(Long id){
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString(){
        return "ID : "+super.getId()+ " Description: " + this.getDescription() + " --Price: " + getPrice() + " --Title: " + this.getTitle() + " "+this.productCategory.getTitle_category();
    }
}
