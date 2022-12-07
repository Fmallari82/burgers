package com.francisco.burgers.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.francisco.burgers.models.Burger;
import com.francisco.burgers.services.BurgerService;

@Controller
@RequestMapping("/burgers")
public class BurgerController {
	
	public final BurgerService burgerServ;
	public BurgerController(BurgerService burgerServ) {
		this.burgerServ = burgerServ;
	}
	
	@GetMapping("/all")
	public String allBurgers(@ModelAttribute("burger") Burger burger, Model model) {
		model.addAttribute("allBurgers", burgerServ.getAll());
		model.addAttribute("burger", new Burger());
		return "index.jsp";
	}

	@GetMapping("/{id}")
	public String oneBurger(@PathVariable("id") Long id, Model model) {
		Burger oneBurger = burgerServ.findOne(id);
		model.addAttribute("oneBurger", oneBurger );
		return "showOne.jsp";
	}
	@GetMapping("/search")
	public String searchBurger(@RequestParam("search") String Search, Model model) {
		model.addAttribute("allBurgers", burgerServ.searchBurger(Search));
		model.addAttribute("donation", new Burger());
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newBurger(@ModelAttribute("burger") Burger burger) {
		
		return "index.jsp";
	}
	
	@PostMapping("/all")
	public String processBurger(
			@Valid 
			@ModelAttribute("burger")
			Burger burger, 
			BindingResult result,
			Model model) 
	{	
		if(result.hasErrors()) {
			model.addAttribute("allBurgers", burgerServ.getAll());
			return "index.jsp";
		}
		burgerServ.create(burger);
		return "redirect:/burgers/all";
	
		}
	@GetMapping("/edit/{id}")
		public String editBurger (
				@PathVariable("id") Long id, Model model) {
			Burger burgerToBeEdited = burgerServ.findOne(id);
			model.addAttribute("burger", burgerToBeEdited);
			return "edit.jsp";
		}

	@PutMapping("/edit/process/{id}")
	public String processEditBurger(
			@Valid 
			@ModelAttribute("burger")
			Burger burger, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		burgerServ.update(burger);
		return "redirect:/burgers/all";
	
}
	@DeleteMapping("/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		burgerServ.deleteByID(id);
		return "redirect:/burgers/all";
	}
}


