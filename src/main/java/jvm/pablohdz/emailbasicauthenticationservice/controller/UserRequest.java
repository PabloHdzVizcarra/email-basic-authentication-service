package jvm.pablohdz.emailbasicauthenticationservice.controller;

import java.sql.Timestamp;
import java.time.Instant;

public class UserRequest {
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private Timestamp createAt;

    public UserRequest() {
        createTime();
    }

    public UserRequest(
            String name,
            String lastname,
            String username,
            String email,
            String password
    ) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        createTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    private void createTime() {
        this.createAt = new Timestamp(Instant.now().toEpochMilli());
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
