package com.francisco.burgers.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 5, max = 200, message="Burger name needs to be at least 5 characters long")
    private String burgerName;
    
    @NotNull
    @Size(min = 5, max = 200, message="Restaurant name needs to be at least 5 characters long")
    private String restaurantName;
    
    
    @NotNull
    @Min(value=0, message="Rating needs to be from 0 to 5")
    @NotNull
    @Max(value=5, message="Rating needs to be from 0 to 5")
    private Integer rating;
    
    @NotNull
    @Size(min = 5, max = 200, message="Notes needs to be at least 5 characters long")
    private String notes;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    

	public Burger() {}

	public Burger(
			@NotNull @Size(min = 5, max = 200, message = "Burger name needs to be at least 5 characters long") String burgerName,
			@NotNull @Size(min = 5, max = 200, message = "Restaurant name needs to be at least 5 characters long") String restaurantName,
			@NotNull @Min(value = 0, message = "Rating needs to be from 0 to 10") Integer rating,
			@NotNull @Size(min = 5, max = 200, message = "Notes needs to be at least 5 characters long") String notes) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}

	public Burger(Long id,
			@NotNull @Size(min = 5, max = 200, message = "Burger name needs to be at least 5 characters long") String burgerName,
			@NotNull @Size(min = 5, max = 200, message = "Restaurant name needs to be at least 5 characters long") String restaurantName,
			@NotNull @Min(value = 0, message = "Rating needs to be from 0 to 10") Integer rating,
			@NotNull @Size(min = 5, max = 200, message = "Notes needs to be at least 5 characters long") String notes) {
		super();
		this.id = id;
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBurgerName() {
		return burgerName;
	}


	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
