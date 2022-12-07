package com.francisco.burgers.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.burgers.models.Burger;
import com.francisco.burgers.services.BurgerService;

@RestController
@RequestMapping("/api")
public class BurgersAPI {

	private final BurgerService burgerServ;

	public BurgersAPI(BurgerService burgerServ) {
		this.burgerServ = burgerServ;
	}

	// Create
	@PostMapping("/burgers")
	public Burger createDonation(
			@RequestParam("burgerName") String burgerName, 
			@RequestParam("restaurantName") String restaurantName,
			@RequestParam("rating") Integer rating, 
			@RequestParam("notes") String notes) {
		Burger newBurger = new Burger(
				burgerName, 
				restaurantName, 
				rating, 
				notes);
		return burgerServ.create(newBurger);
	}

	// Read All
	@GetMapping("/burgers")
	public List<Burger> findAllBurgers() {
		return burgerServ.getAll();
	}

	// Read one
	@GetMapping("/burgers/{id}")
	public Burger findOneBurger(@PathVariable("id") Long id) {
		return burgerServ.findOne(id);
	}

	//Update one
	@PutMapping("/burgers/{id}")
	public Burger findOneAndUpdate(
        @PathVariable("id") Long id, 
        @RequestParam("burgerName") String burgerName,
        @RequestParam("restaurantName") String restaurantName, 
        @RequestParam("rating") Integer rating,
        @RequestParam("notes") String notes) {
		return burgerServ.update(
				id, 
				burgerName, 
				restaurantName, 
				rating, 
				notes);
	}

	//Delete 
	@DeleteMapping("/burgers/{id}")
	public void destroy(@PathVariable("id") Long id) {
		burgerServ.deleteByID(id);
	}
}