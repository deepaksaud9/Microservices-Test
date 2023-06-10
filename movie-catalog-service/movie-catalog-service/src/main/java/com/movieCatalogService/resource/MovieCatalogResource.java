package com.movieCatalogService.resource;

import com.movieCatalogService.model.CatalogItems;
import com.movieCatalogService.model.Movie;
import com.movieCatalogService.model.Rating;
import com.movieCatalogService.model.UserRating;
import com.movieCatalogService.services.MovieInfo;
import com.movieCatalogService.services.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfo movieInfo;

    @Autowired
    private UserRatingInfo userRatingInfo;

//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItems> getCatalog(@PathVariable("userId") String userId){
        //get all rated movies IDs
        UserRating ratings = userRatingInfo.getUserRating(userId);

       return ratings.getUserRating().stream()
               .map(rating -> movieInfo.getCatalogItems(rating))
               .collect(Collectors.toList());
    }
}


/*                           we can use react web when rest template will deprecated.                           OR,
       Movie movie = webClientBuilder.build()
                   .get()
                   .uri("http://localhost:8082/movies/"+rating.getMovieId())
                   .retrieve()
                   .bodyToMono(Movie.class)
                   .block();
*/