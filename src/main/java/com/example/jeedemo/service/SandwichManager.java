package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Sandwich;

@Stateless
public class SandwichManager {

	@PersistenceContext
	EntityManager em;

	public void addSandwich(Sandwich sandwich) {
		sandwich.setId(null);
		em.persist(sandwich);
	}

	public void deleteSandwich(Sandwich sandwich) {
		sandwich = em.find(Sandwich.class, sandwich.getId());
		em.remove(sandwich);
	}

	@SuppressWarnings("unchecked")
	public List<Sandwich> getAllSandwiches() {
		return em.createNamedQuery("sandwich.all").getResultList();
	}

	public List<Car> getOwnedCars(Sandwich sandwich) {
		sandwich = em.find(Sandwich.class, sandwich.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Car> cars = new ArrayList<Car>(sandwich.getCars());
		return cars;
	}

}
