package by.alst.project.jdbc.entity;

import java.util.Objects;

public class Gender {
    private Integer id;
    private String gender;

    public Gender() {
    }

    public Gender(Integer id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender1 = (Gender) o;
        return Objects.equals(id, gender1.id) && Objects.equals(gender, gender1.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender);
    }

    @Override
    public String toString() {
        return "Gender{" +
               "id=" + id +
               ", gender='" + gender + '\'' +
               '}';
    }
}
