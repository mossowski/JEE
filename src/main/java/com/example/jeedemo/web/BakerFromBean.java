package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Baker;
import com.example.jeedemo.service.BakerManager;

@SessionScoped
@Named("bakerBean")
public class BakerFromBean implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	private Baker baker = new Baker();

	private ListDataModel<Baker> bakers = new ListDataModel<Baker>();
 
	@Inject
	private BakerManager bm;
	
	public Baker getBaker() 
	{
		return baker;
	}
	
	public void setBaker(Baker baker) 
	{
		this.baker = baker;
	}
	
	public ListDataModel<Baker> getAllBakers() 
	{
        bakers.setWrappedData(bm.getAllBakers());
        return bakers;
    }

    public String addBaker() 
    {
        bm.addBaker(baker);
        //return "list";
        return null;
    }
    
    public String deleteBaker() 
    {
    	Baker bakerToDelete = bakers.getRowData();
		bm.deleteBaker(bakerToDelete);
		return null;
	}
    
    public String editBaker() 
    {
		bm.editBaker(baker);
		return null;
	}
}