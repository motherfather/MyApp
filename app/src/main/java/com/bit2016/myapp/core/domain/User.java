package com.bit2016.myapp.core.domain;

/**
 * Created by BITUSER on 2016-12-02.
 */

public class User {
    private long id;
    private String email;
    private String name;
    private int status;
    private String phone;
    private String profilePic;

    // alt + insert ==> getter setter tostring 등...
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }
}
