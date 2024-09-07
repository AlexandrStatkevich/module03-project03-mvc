package by.alst.project.jdbc.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private Integer id;
    private Integer productGroupId;
    private String productName;
    private String productDescription;
    private Integer productProducerId;
    private Integer countryOriginId;
    private Integer productUnitId;
    private LocalDateTime productArrivalDate;
    private BigDecimal productCost;
    private BigDecimal productAmount;
    private LocalDateTime productCardDateCreation;

    public Product() {
    }

    public Product(Integer id, Integer productGroupId, String productName, String productDescription, Integer productProducerId, Integer countryOriginId, Integer productUnitId, LocalDateTime productArrivalDate, BigDecimal productCost, BigDecimal productAmount, LocalDateTime productCardDateCreation) {
        this.id = id;
        this.productGroupId = productGroupId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productProducerId = productProducerId;
        this.countryOriginId = countryOriginId;
        this.productUnitId = productUnitId;
        this.productArrivalDate = productArrivalDate;
        this.productCost = productCost;
        this.productAmount = productAmount;
        this.productCardDateCreation = productCardDateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Integer productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductProducerId() {
        return productProducerId;
    }

    public void setProductProducerId(Integer productProducerId) {
        this.productProducerId = productProducerId;
    }

    public Integer getCountryOriginId() {
        return countryOriginId;
    }

    public void setCountryOriginId(Integer countryOriginId) {
        this.countryOriginId = countryOriginId;
    }

    public Integer getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(Integer productUnitId) {
        this.productUnitId = productUnitId;
    }

    public LocalDateTime getProductArrivalDate() {
        return productArrivalDate;
    }

    public void setProductArrivalDate(LocalDateTime productArrivalDate) {
        this.productArrivalDate = productArrivalDate;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public LocalDateTime getProductCardDateCreation() {
        return productCardDateCreation;
    }

    public void setProductCardDateCreation(LocalDateTime productCardDateCreation) {
        this.productCardDateCreation = productCardDateCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productGroupId, product.productGroupId) && Objects.equals(productName, product.productName) && Objects.equals(productDescription, product.productDescription) && Objects.equals(productProducerId, product.productProducerId) && Objects.equals(countryOriginId, product.countryOriginId) && Objects.equals(productUnitId, product.productUnitId) && Objects.equals(productArrivalDate, product.productArrivalDate) && Objects.equals(productCost, product.productCost) && Objects.equals(productAmount, product.productAmount) && Objects.equals(productCardDateCreation, product.productCardDateCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productGroupId, productName, productDescription, productProducerId, countryOriginId, productUnitId, productArrivalDate, productCost, productAmount, productCardDateCreation);
    }

    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", productGroupId=" + productGroupId +
               ", productName='" + productName + '\'' +
               ", productDescription='" + productDescription + '\'' +
               ", productProducerId=" + productProducerId +
               ", countryOriginId=" + countryOriginId +
               ", productUnitId=" + productUnitId +
               ", productArrivalDate=" + productArrivalDate +
               ", productCost=" + productCost +
               ", productAmount=" + productAmount +
               ", productCardDateCreation=" + productCardDateCreation +
               '}';
    }
}
