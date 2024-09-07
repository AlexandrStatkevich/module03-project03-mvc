package by.alst.project.jdbc.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Logging {
    private Integer id;
    private Integer usersId;
    private LocalDateTime usersAuthenticationTime;
    private LocalDateTime usersLogOutTime;

    public Logging() {
    }

    public Logging(Integer id, Integer usersId, LocalDateTime usersAuthenticationTime, LocalDateTime usersLogOutTime) {
        this.id = id;
        this.usersId = usersId;
        this.usersAuthenticationTime = usersAuthenticationTime;
        this.usersLogOutTime = usersLogOutTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public LocalDateTime getUsersAuthenticationTime() {
        return usersAuthenticationTime;
    }

    public void setUsersAuthenticationTime(LocalDateTime usersAuthenticationTime) {
        this.usersAuthenticationTime = usersAuthenticationTime;
    }

    public LocalDateTime getUsersLogOutTime() {
        return usersLogOutTime;
    }

    public void setUsersLogOutTime(LocalDateTime usersLogOutTime) {
        this.usersLogOutTime = usersLogOutTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logging logging = (Logging) o;
        return Objects.equals(id, logging.id) && Objects.equals(usersId, logging.usersId) && Objects.equals(usersAuthenticationTime, logging.usersAuthenticationTime) && Objects.equals(usersLogOutTime, logging.usersLogOutTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersId, usersAuthenticationTime, usersLogOutTime);
    }

    @Override
    public String toString() {
        return "Logging{" +
               "id=" + id +
               ", usersId=" + usersId +
               ", usersAuthenticationTime=" + usersAuthenticationTime +
               ", usersLogOutTime=" + usersLogOutTime +
               '}';
    }
}
