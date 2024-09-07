package by.alst.project.jdbc.entity;

import java.util.Objects;

public class Producer {
    private Integer id;
    private String producerName;
    private String producerAddress;

    public Producer() {
    }

    public Producer(Integer id, String producerName, String producerAddress) {
        this.id = id;
        this.producerName = producerName;
        this.producerAddress = producerAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerAddress() {
        return producerAddress;
    }

    public void setProducerAddress(String producerAddress) {
        this.producerAddress = producerAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Objects.equals(id, producer.id) && Objects.equals(producerName, producer.producerName) && Objects.equals(producerAddress, producer.producerAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producerName, producerAddress);
    }

    @Override
    public String toString() {
        return "Producer{" +
               "id=" + id +
               ", producerName='" + producerName + '\'' +
               ", producerAddress='" + producerAddress + '\'' +
               '}';
    }
}
