package com.example.crowdfunding.Domain;

import com.example.crowdfunding.view.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonView(Views.Public.class)
    private LocalDate date;
    @ManyToOne
    @JsonView(Views.FullGoal.class)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JsonView(Views.User.class)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    public Donation(LocalDate date, User user, Goal goal, Integer amount) {
        this.date = date;
        this.user = user;
        this.goal = goal;
        this.amount = amount;
    }

    public Donation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    @JsonView(Views.Public.class)
    private Integer amount;

}
