package com.example.exam.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class StudentDto {
    private Integer id;

    @NotNull()
    @NotEmpty(message = "Name is not empty")
    @Length(min = 3 , max = 20,message = "Name is out of range")
    private String name;

    @NotNull()
    @NotEmpty(message = "codeStudent is not empty")
    @Length(min = 3 , max = 20,message = "codeStudent is out of range")
    private String codeStudent;

    @NotNull()
    @NotEmpty(message = "gender is not empty")
    @Length(min = 3 , max = 20,message = "gender is out of range")
    private String gender;

    @NotNull()
    @NotEmpty(message = "email is not empty")
    @Length(min = 3 , max = 20,message = "email is out of range")
    private String email;

    @NotNull()
    @NotEmpty(message = "phone is not empty")
    @Length(min = 3 , max = 20,message = "phone is out of range")
    private String phone;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date birthDay;

    @NotNull()
    @NotEmpty(message = "homeTown is not empty")
    @Length(min = 3 , max = 20,message = "homeTown is out of range")
    private String homeTown;

    public StudentDto() {
    }

    public StudentDto(Integer id, String name, String codeStudent, String gender, String email, String phone, Date birthDay, String homeTown) {
        this.id = id;
        this.name = name;
        this.codeStudent = codeStudent;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
        this.homeTown = homeTown;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
}
