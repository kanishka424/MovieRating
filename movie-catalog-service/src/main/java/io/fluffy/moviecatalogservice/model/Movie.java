package io.fluffy.moviecatalogservice.model;

public class Movie {
    public String movieId;
    public String name;

    public Movie() { //when you have to Marshall and unmarshall you need to provide an empty constructor

    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
