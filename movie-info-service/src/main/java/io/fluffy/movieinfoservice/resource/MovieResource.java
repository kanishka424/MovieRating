package io.fluffy.movieinfoservice.resource;


import io.fluffy.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie getMovie(String  movieId){
        return new Movie(movieId,"Test me");
    }


}
