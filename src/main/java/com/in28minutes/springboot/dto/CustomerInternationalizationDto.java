package com.in28minutes.springboot.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Column;


public class CustomerInternationalizationDto {
    private Integer id;

    private String name_VN;

    private String name_EN;

    private Integer age;

    private String email;

    public CustomerInternationalizationDto() {
    }

    public CustomerInternationalizationDto(Integer id, String name_VN, String name_EN, Integer age, String email) {
        this.id = id;
        this.name_VN = name_VN;
        this.name_EN = name_EN;
        this.age = age;
        this.email = email;
    }

    public CustomerInternationalizationDto(Integer id, String name_VN, Integer age, String email) {
        this.id = id;
        this.name_VN = name_VN;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_VN() {
        return name_VN;
    }

    public void setName_VN(String name_VN) {
        this.name_VN = name_VN;
    }

    public String getName_EN() {
        return name_EN;
    }

    public void setName_EN( String name_EN) {
        this.name_EN = name_EN;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerInternationalizationDto{" +
                "id=" + id +
                ", name_VN='" + name_VN + '\'' +
                ", name_EN='" + name_EN + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
