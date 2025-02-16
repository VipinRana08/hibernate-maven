package com.practice.hibernate_practice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Superhero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Tells Hibernate to generate the id automatically
    private int id;
    private String name;
    private String power;
    
    public Superhero() {}

    public Superhero(String name, String power) {
        this.name = name;
        this.power = power;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
    
    @Override
    public String toString() {
        return "Superhero [id=" + id + ", name=" + name + ", power=" + power + "]";
    }
	
}
