package com.sabin.moviecatalogservice.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Rating {
	
	private String movieid;
	private int rating;
	
	public String getMovieid() {
		return movieid;
	}
	
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

}
