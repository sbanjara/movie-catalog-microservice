package com.sabin.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sabin.moviecatalogservice.models.CatalogItem;
import com.sabin.moviecatalogservice.models.Movie;
import com.sabin.moviecatalogservice.models.Rating;

@RestController
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webclientBuilder;
	
	@Autowired
	private Rating rating;
	@Autowired
	private Rating rating1;
	
	@RequestMapping("/home")
	public String getHome() {
		return "Welcome to Movie Catalog API";
	}

	@RequestMapping("/movie-catalog/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userid) {
		
		/* First Step: Get the ratings data */
		
		List<Rating> ratings = new ArrayList<Rating>();
		rating.setMovieid("1");
		rating.setRating(4);
		ratings.add(rating);
		rating1.setMovieid("2");
		rating1.setRating(5);
		ratings.add(rating1);

		/* Second Step: For each movieid in the ratings, call movie-info-service */
		
		return ratings.stream().map(rating -> {
			
			/* Call to the Microservice API using RestTemplate */
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieid(), Movie.class);
			 
			
			/* Microservice call using the WebClient **
			Movie movie = webclientBuilder.build()
							.get()
							.uri("http://localhost:8082/movies/" + rating.getMovieid())
							.retrieve()
							.bodyToMono(Movie.class) //Mono is a promise of object which will be gotten asynchronously 
							.block(); //We're blocking until we get the Movie object
			*** End of the WebClient call call */
			
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		})
		.collect(Collectors.toList());
		
	}

}
