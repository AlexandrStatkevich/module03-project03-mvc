package by.alst.project.jdbc.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Checkout {
    private Integer id;
    private Integer loggingId;
    private LocalDateTime checkoutTime;

    public Checkout() {
    }

    public Checkout(Integer id, Integer loggingId, LocalDateTime checkoutTime) {
        this.id = id;
        this.loggingId = loggingId;
        this.checkoutTime = checkoutTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoggingId() {
        return loggingId;
    }

    public void setLoggingId(Integer loggingId) {
        this.loggingId = loggingId;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkout checkout = (Checkout) o;
        return Objects.equals(id, checkout.id) && Objects.equals(loggingId, checkout.loggingId) && Objects.equals(checkoutTime, checkout.checkoutTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loggingId, checkoutTime);
    }

    @Override
    public String toString() {
        return "Checkout{" +
               "id=" + id +
               ", loggingId=" + loggingId +
               ", checkoutTime=" + checkoutTime +
               '}';
    }
}
