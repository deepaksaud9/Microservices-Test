package com.movieCatalogService.services;

import com.movieCatalogService.model.CatalogItems;
import com.movieCatalogService.model.Movie;
import com.movieCatalogService.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItems getCatalogItems(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getMovieId(), Movie.class);
        //pull them all together
        return new CatalogItems(rating.getMovieId(), movie.getName(), movie.getDesc(), rating.getRating());
    }

    public CatalogItems getFallbackCatalogItem(Rating rating) {
        return new CatalogItems("no movies found", "", "",rating.getRating());
    }

}
