package br.com.ia.microservicecourseinit.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@ApiModel(description="Users of the system")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name should be at least 2 characters")
    @ApiModelProperty(notes="Name should have at least 2 characters")
    private String name;
    private String lastName;

    @Past
    @ApiModelProperty(notes="Birth date should be in the past")
    private LocalDate birthDay;
    private String sex;

    public User() {
    }

    public User(String name, String lastName, LocalDate birthDay, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
