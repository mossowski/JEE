package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Seller;
import com.example.jeedemo.domain.Sandwich;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class SellingManager {

	@PersistenceContext
	EntityManager em;

	public void removeSeller(Long sandwichId, Long sellerId) {

		Sandwich sandwich = em.find(Sandwich.class, sandwichId);
		Seller seller = em.find(Seller.class, sellerId);
		seller.setRemoved(true);

		sandwich.getSellers().add(seller);
	}

	@SuppressWarnings("unchecked")
	public List<Seller> getAvailableSellers() {
		return em.createNamedQuery("seller.removed").getResultList();
	}

	public void disposeSeller(Sandwich sandwich, Seller seller) {

		sandwich = em.find(Sandwich.class, sandwich.getId());
		seller = em.find(Seller.class, seller.getId());

		Seller toRemove = null;
		for (Seller aSeller : sandwich.getSellers())
			if (aSeller.getId().compareTo(seller.getId()) == 0) {
				toRemove = aSeller;
				break;
			}

		if (toRemove != null)
			sandwich.getSellers().remove(toRemove);
		
		seller.setRemoved(false);
	}
}
