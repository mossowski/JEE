package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Seller;



@Stateless
public class SellerManager {

	@PersistenceContext
	EntityManager em;

	public void addSeller(Seller seller) {

        seller.setId(null);
        em.persist(seller);
    }
	
	public void deleteSeller(Seller seller) {
		seller = em.find(Seller.class, seller.getId());
		em.remove(seller);
	}
	
	public void editSeller(Seller sellerToChange) {
        em.merge(sellerToChange);
    }

    @SuppressWarnings("unchecked")
    public List<Seller> getAllSellers() {
        return em.createNamedQuery("seller.all").getResultList();
    }
}
