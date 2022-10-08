package com.example.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tool")
public class Tool implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idToll;

    private String brand;
    @Column(name = "year_b")
    private Integer year;
    private String description;
    private String name;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("tools")
    private Category category;

    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy = "tool")
    @JsonIgnoreProperties({"tool","client"})
    private List<Message> messages;

    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy = "tool")
    @JsonIgnoreProperties({"tool","messages"})
    private List<Reservation> reservations;


    public Integer getIdToll() {
        return idToll;
    }

    public void setIdToll(Integer idToll) {
        this.idToll = idToll;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}


