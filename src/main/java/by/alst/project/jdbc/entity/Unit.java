package by.alst.project.jdbc.entity;

import java.util.Objects;

public class Unit {
    private Integer id;
    private String unit;

    public Unit() {
    }

    public Unit(Integer id, String unit) {
        this.id = id;
        this.unit = unit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit1 = (Unit) o;
        return Objects.equals(id, unit1.id) && Objects.equals(unit, unit1.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unit);
    }

    @Override
    public String toString() {
        return "Unit{" +
               "id=" + id +
               ", unit='" + unit + '\'' +
               '}';
    }
}
