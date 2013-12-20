package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Sandwich;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class SellingManager {

	@PersistenceContext
	EntityManager em;

	public void sellCar(Long personId, Long carId) {

		Sandwich sandwich = em.find(Sandwich.class, personId);
		Car car = em.find(Car.class, carId);
		car.setSold(true);

		sandwich.getCars().add(car);
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAvailableCars() {
		return em.createNamedQuery("car.unsold").getResultList();
	}

	public void disposeCar(Sandwich sandwich, Car car) {

		sandwich = em.find(Sandwich.class, sandwich.getId());
		car = em.find(Car.class, car.getId());

		Car toRemove = null;
		// lazy loading here (person.getCars)
		for (Car aCar : sandwich.getCars())
			if (aCar.getId().compareTo(car.getId()) == 0) {
				toRemove = aCar;
				break;
			}

		if (toRemove != null)
			sandwich.getCars().remove(toRemove);
		
		car.setSold(false);
	}
}
