package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.service.SandwichManager;
import com.example.jeedemo.service.SellingManager;

@SessionScoped
@Named("sandwichBean")
public class SandwichFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sandwich sandwich = new Sandwich();
	private ListDataModel<Sandwich> sandwiches = new ListDataModel<Sandwich>();
	
	private Sandwich sandwichToShow = new Sandwich();
	private ListDataModel<Car> ownedCars = new ListDataModel<Car>();


	@Inject
	private SandwichManager pm;
	
	@Inject
	private SellingManager sm;

	public Sandwich getSandwich() {
		return sandwich;
	}
	public void setSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
	}
	
	public ListDataModel<Sandwich> getAllSandwiches() {
		sandwiches.setWrappedData(pm.getAllSandwiches());
		return sandwiches;
	}

	public ListDataModel<Car> getOwnedCars() {
		ownedCars.setWrappedData(pm.getOwnedCars(sandwichToShow));
		return ownedCars;
	}
	
	// Actions
	public String addSandwich() {
		pm.addSandwich(sandwich);
		return "showSandwiches";
		//return null;
	}

	public String deleteSandwich() {
		Sandwich sandwichToDelete = sandwiches.getRowData();
		pm.deleteSandwich(sandwichToDelete);
		return null;
	}
	
	public String showDetails() {
		sandwichToShow = sandwiches.getRowData();
		return "details";
	}
	
	public String disposeCar(){
		Car carToDispose = ownedCars.getRowData();
		sm.disposeCar(sandwichToShow, carToDispose);
		return null;
	}
}