package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.service.SandwichManager;
import com.example.jeedemo.service.SellingManager;

@SessionScoped
@Named("saleBean")
public class SaleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SellingManager sm;

	@Inject
	private SandwichManager pm;

	private Long carId;
	private Long sandwichId;
	
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public Long getSandwichId() {
		return sandwichId;
	}
	public void setSandwichId(Long sandwichId) {
		this.sandwichId = sandwichId;
	}

	public List<Car> getAvailableCars() {
		return sm.getAvailableCars();
	}

	public List<Sandwich> getAllSandwiches() {
		return pm.getAllSandwiches();
	}

	public String sellCar() {
		sm.sellCar(sandwichId, carId);
		return null;
	}
}
