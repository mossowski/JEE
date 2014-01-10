package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Seller;
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

	public List<Seller> getOwnedSellers(Sandwich sandwich) {
		sandwich = em.find(Sandwich.class, sandwich.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Seller> sellers = new ArrayList<Seller>(sandwich.getSellers());
		return sellers;
	}

}
