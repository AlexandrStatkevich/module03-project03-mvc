package by.alst.project.jdbc.entity;

import java.util.Objects;

public class Subcategory {
    private Integer id;
    private Integer categoryId;
    private String subcategory;

    public Subcategory() {
    }

    public Subcategory(Integer id, Integer categoryId, String subcategory) {
        this.id = id;
        this.categoryId = categoryId;
        this.subcategory = subcategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subcategory that = (Subcategory) o;
        return Objects.equals(id, that.id) && Objects.equals(categoryId, that.categoryId) && Objects.equals(subcategory, that.subcategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, subcategory);
    }

    @Override
    public String toString() {
        return "Subcategory{" +
               "id=" + id +
               ", categoryId=" + categoryId +
               ", subcategory='" + subcategory + '\'' +
               '}';
    }
}
