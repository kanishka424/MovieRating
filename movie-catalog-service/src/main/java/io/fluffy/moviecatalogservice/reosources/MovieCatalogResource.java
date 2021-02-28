package io.fluffy.moviecatalogservice.reosources;


import io.fluffy.moviecatalogservice.model.CatalogItem;
import io.fluffy.moviecatalogservice.model.Movie;
import io.fluffy.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){



//        RestTemplate restTemplate=new RestTemplate();

        List<Rating> ratings=Arrays.asList(
                new Rating("1234",4),//Some buddy came and ask for movies a usser has watched,for now just think this is the data we received from rating-data-service  api,we hardcoded it
                new Rating("5678",3)
        );




        return ratings.stream().map(
                rating->{

                    Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(),Movie.class);
                    return  new CatalogItem(movie.getName(),"Desc",rating.getRating());
                }).collect(Collectors.toList());





    }
}





