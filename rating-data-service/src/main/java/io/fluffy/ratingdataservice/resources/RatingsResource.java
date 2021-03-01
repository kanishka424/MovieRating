package io.fluffy.ratingdataservice.resources;


import io.fluffy.ratingdataservice.models.Rating;
import io.fluffy.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,5);
    };


    @RequestMapping("/users/{userId}")
    public UserRating  getUserRating(@PathVariable String userId){
        List<Rating> ratings= Arrays.asList(
                new Rating("1234",4),//Some buddy came and ask for movies a user has watched,for now just think this is the data we received from rating-data-service  api,we hardcoded it
                new Rating("5678",3)
        );

        UserRating userRating=new UserRating();//we don't return a list we will wrap around an object and send the list
        userRating.setUserRating(ratings);
        return userRating;
    };

}

