package com.francisco.burgers.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.francisco.burgers.models.Burger;
import com.francisco.burgers.repositories.BurgerRepository;


@Service
public class BurgerService {
	// adding the burger repository as a dependency
	private final BurgerRepository burgerRepo;

	public BurgerService(BurgerRepository burgerRepo) {
		this.burgerRepo = burgerRepo;
	}

	// returns all the burgers
	public List<Burger> getAll() {
		return burgerRepo.findAll();
	}

	// creates a burger
	public Burger create(Burger burger) {
		return burgerRepo.save(burger);
	}

	// retrieves a burger
	public Burger findOne(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if (optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}
	}
	public Burger update(
			Long id, 
			String burgerName, 
			String restaurantName, 
			Integer rating, 
			String notes) {
		Burger burgerToBeUpdated = new Burger(
				id, 
				burgerName, 
				restaurantName, 
				rating, 
				notes);
		return burgerRepo.save(burgerToBeUpdated);
	}
	public Burger update(Burger burger) {
		return burgerRepo.save(burger);
	}
	
	public String deleteByID(Long id) {
		burgerRepo.deleteById(id);
		return "you deleted the record with the id of: " + id;
	}

	public Object searchBurger(String search) {
		return burgerRepo.findByBurgerNameContaining(search);
}
}
