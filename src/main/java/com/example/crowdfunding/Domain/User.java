package com.example.crowdfunding.Domain;

import com.example.crowdfunding.view.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Public.class)
    private String email;
    @JsonView(Views.Public.class)
    private Integer balance;
    @JsonView(Views.Public.class)
    private String username;
    @JsonIgnore
    @OneToMany(mappedBy = "creator")
    private Set<Goal> goals;

    public Set<Donation> getDonations() {
        return donations;
    }

    public void setDonations(Set<Donation> donations) {
        this.donations = donations;
    }
    @OneToMany(mappedBy = "user")
    @JsonView(Views.User.class)
    private Set<Donation> donations;
    public Long getId() {
        return id;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    public User(Long id, String name, String email, Integer balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }
}