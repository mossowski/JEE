package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

<<<<<<< HEAD
import com.example.jeedemo.domain.Baker;
=======
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556
import com.example.jeedemo.domain.Seller;
import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.domain.Ingredient;

@Stateless
public class SandwichManager {

	@PersistenceContext
	EntityManager em;
	
	int price;

	public void addSandwich(Sandwich sandwich, Long sellerId, Long[] ingredientId, Long bakerId) {
		
		sandwich.setIngredients(new ArrayList<Ingredient>());
        sandwich.setSeller(null);
        sandwich.setBaker(null);
		sandwich.setId(null);
		
		for(Long x: ingredientId)
		{	
			Ingredient ingredients = em.find(Ingredient.class,x);
			sandwich.getIngredients().add(ingredients);
	    }
		
		Baker baker = em.find(Baker.class, bakerId);
		sandwich.setBaker(baker);
		
		Seller seller = em.find(Seller.class, sellerId);
		sandwich.setSeller(seller);
		
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
	
	public void editSandwich(Sandwich sandwichToChange) {
            em.merge(sandwichToChange);
    }

<<<<<<< HEAD
	 @SuppressWarnings("unchecked")
	public List<Sandwich> findSandwichByName(String name) {
             return em.createNamedQuery("sandwich.findByName").setParameter("name", name ).getResultList();
     }
=======
	public List<Seller> getOwnedSellers(Sandwich sandwich) {
		sandwich = em.find(Sandwich.class, sandwich.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Seller> sellers = new ArrayList<Seller>(sandwich.getSellers());
		return sellers;
	}
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556

}
