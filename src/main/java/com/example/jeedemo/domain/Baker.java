package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ 
        @NamedQuery(name = "baker.all", query = "Select b from Baker b")
})

public class Baker {

	private Long id; 
    
    String firstName;
    String lastName;
    
    Sandwich sandwich;

    @OneToOne(optional=false, mappedBy="baker")
    public Sandwich getSandwich() {
            return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
            this.sandwich = sandwich;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
            return id;
    }

    public void setId(Long id) {
            this.id = id;
    }

    public String getFirstName() {
            return firstName;
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
