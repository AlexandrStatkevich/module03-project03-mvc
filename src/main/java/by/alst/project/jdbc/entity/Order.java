package by.alst.project.jdbc.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
    private Integer id;
    private Integer checkoutId;
    private Integer productId;
    private BigDecimal productAmount;

    public Order() {
    }

    public Order(Integer id, Integer checkoutId, Integer productId, BigDecimal productAmount) {
        this.id = id;
        this.checkoutId = checkoutId;
        this.productId = productId;
        this.productAmount = productAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Integer checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(checkoutId, order.checkoutId) && Objects.equals(productId, order.productId) && Objects.equals(productAmount, order.productAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkoutId, productId, productAmount);
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", checkoutId=" + checkoutId +
               ", productId=" + productId +
               ", productAmount=" + productAmount +
               '}';
    }
}
