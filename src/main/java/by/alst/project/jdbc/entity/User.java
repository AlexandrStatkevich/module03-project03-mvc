package by.alst.project.jdbc.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private Integer id;
    private String email;
    private String password;
    private LocalDateTime registrationDate;
    private Integer roleId;
    private Integer genderId;

    public User() {
    }

    public User(Integer id, String email, String password, LocalDateTime registrationDate, Integer roleId, Integer genderId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.roleId = roleId;
        this.genderId = genderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(registrationDate, user.registrationDate) && Objects.equals(roleId, user.roleId) && Objects.equals(genderId, user.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, registrationDate, roleId, genderId);
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", registrationDate=" + registrationDate +
               ", roleId=" + roleId +
               ", genderId=" + genderId +
               '}';
    }
}
