package com.sabin.moviecatalogservice.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Movie {
	
	private String movieid;
	private String name;
	private String description;
	
	public String getMovieid() {
		return movieid;
	}
	
	public void setMovieid(String movieid) {
		this.movieid = movieid;
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

}
