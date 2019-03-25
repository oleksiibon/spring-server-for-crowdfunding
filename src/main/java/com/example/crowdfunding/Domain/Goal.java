package com.example.crowdfunding.Domain;

import javax.persistence.*;

@Entity
@Table
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String picture;
    private Integer cost;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    public Long getId() {
        return id;
    }

    public Goal() {
    }

    public Goal(String name, String picture, Integer cost, User creator) {
        this.name = name;
        this.picture = picture;
        this.cost = cost;
        this.creator = creator;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
