package com.example.crowdfunding.Domain;

import com.example.crowdfunding.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Public.class)
    private String picture;
    @JsonView(Views.Public.class)
    private Integer cost;
    @JsonView(Views.Public.class)
    private String description;
    @ManyToOne
    @JsonView(Views.FullGoal.class)
    @JoinColumn(name = "creator_id")
    private User creator;
    @ManyToOne
    @JsonView(Views.Public.class)
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "goal")
    @JsonView(Views.FullGoal.class)
    private Set<Donation> donations;


    public Goal() {
    }

    public Goal(String name, String picture, Integer cost, User creator, Category category, String description) {
        this.name = name;
        this.picture = picture;
        this.cost = cost;
        this.creator = creator;
        this.category = category;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<Donation> getDonations() {
        return donations;
    }

    public void setDonations(Set<Donation> donations) {
        this.donations = donations;
    }

    public Long getId() {
        return id;
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
