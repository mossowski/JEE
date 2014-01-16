package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Baker;

@Stateless
public class BakerManager {
	
	 @PersistenceContext
     EntityManager em;
             
     public void addBaker(Baker baker) {

    	  baker.setId(null);
          em.persist(baker);
     }
             
     @SuppressWarnings("unchecked")
     public List<Baker> getAllBakers() {
    	 
          return em.createNamedQuery("baker.all").getResultList();
     }
             
     public void deleteBaker(Baker baker) {
    	     
    	  baker = em.find(Baker.class, baker.getId());
          em.remove(baker);
     }
     
     public void editBaker(Baker bakerToChange) {
         em.merge(bakerToChange);
     }

}
