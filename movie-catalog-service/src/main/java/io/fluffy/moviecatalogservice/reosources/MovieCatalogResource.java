package io.fluffy.moviecatalogservice.reosources;


import io.fluffy.moviecatalogservice.model.CatalogItem;
import io.fluffy.moviecatalogservice.model.Movie;
import io.fluffy.moviecatalogservice.model.Rating;
import io.fluffy.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController//makes this a rest control
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;//calling a bean instances

//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){



//        RestTemplate restTemplate=new RestTemplate();

        UserRating ratings=restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRating.class);

        return ratings.userRating.stream().map(
                rating->{

                    Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);//this are not URLs but service dicoveries in Eureka server,   RestTemplate knows it(the first argument)


                    return  new CatalogItem(movie.getName(),"Desc",rating.getRating());
                }).collect(Collectors.toList());





    }
}





