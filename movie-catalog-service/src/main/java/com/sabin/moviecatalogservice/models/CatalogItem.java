package com.sabin.moviecatalogservice.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class CatalogItem {
	
	private String name;
	private String description;
	private int rating;
	
	public CatalogItem(String n, String des, int rating) {
		this.name = n;
		this.description = des;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

}
