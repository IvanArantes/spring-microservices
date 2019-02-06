package br.com.ia.microservicecourseinit.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

@JsonFilter("orderFilter")
public class Order {

    @JsonIgnore //Requisição não retorna o atributo
    private Integer id;

    private LocalDate orderDate;
    private String userName;

    public Order() {
    }

    public Order(Integer id, LocalDate orderDate, String userName) {
        this.id = id;
        this.orderDate = orderDate;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
