package by.alst.project.jdbc.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Delivery {
    private Integer checkoutId;
    private String deliveryAddress;
    private LocalDateTime deliveryDateTime;

    public Delivery() {
    }

    public Delivery(Integer checkoutId, String deliveryAddress, LocalDateTime deliveryDateTime) {
        this.checkoutId = checkoutId;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDateTime = deliveryDateTime;
    }

    public Integer getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Integer checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(checkoutId, delivery.checkoutId) && Objects.equals(deliveryAddress, delivery.deliveryAddress) && Objects.equals(deliveryDateTime, delivery.deliveryDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkoutId, deliveryAddress, deliveryDateTime);
    }

    @Override
    public String toString() {
        return "Delivery{" +
               "checkoutId=" + checkoutId +
               ", deliveryAddress='" + deliveryAddress + '\'' +
               ", deliveryDateTime=" + deliveryDateTime +
               '}';
    }
}
