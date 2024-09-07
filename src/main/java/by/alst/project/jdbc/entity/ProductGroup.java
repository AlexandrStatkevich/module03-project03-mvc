package by.alst.project.jdbc.entity;

import java.util.Objects;

public class ProductGroup {
    private Integer id;
    private Integer subcategoryId;
    private String productGroup;

    public ProductGroup() {
    }

    public ProductGroup(Integer id, Integer subcategoryId, String productGroup) {
        this.id = id;
        this.subcategoryId = subcategoryId;
        this.productGroup = productGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductGroup that = (ProductGroup) o;
        return Objects.equals(id, that.id) && Objects.equals(subcategoryId, that.subcategoryId) && Objects.equals(productGroup, that.productGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subcategoryId, productGroup);
    }

    @Override
    public String toString() {
        return "ProductGroup{" +
               "id=" + id +
               ", subcategoryId=" + subcategoryId +
               ", productGroup='" + productGroup + '\'' +
               '}';
    }
}
