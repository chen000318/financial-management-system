package com.jr.entry;

public class Enterprise {

    private int id;
    private String name;
    private String socialUniformCcode;
    private String email;
    private String phone;
    private String address;
    private String scale;
    private String fax;

    public Enterprise() {
    }

    public Enterprise(int id, String name, String socialUniformCcode, String email, String phone, String address, String scale, String fax) {
        this.id = id;
        this.name = name;
        this.socialUniformCcode = socialUniformCcode;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.scale = scale;
        this.fax = fax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialUniformCcode() {
        return socialUniformCcode;
    }

    public void setSocialUniformCcode(String socialUniformCcode) {
        this.socialUniformCcode = socialUniformCcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", socialUniformCcode='" + socialUniformCcode + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", scale='" + scale + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
