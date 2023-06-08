package com.ratingDataService.resource;

import com.ratingDataService.mode.Rating;
import com.ratingDataService.mode.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){

        return new Rating(movieId,4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("111",4),
                new Rating("112",5),
                new Rating("113",2)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;


    }

}
