package dev.jtphan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//This is where most Business Logic will go
public class MovieService {
    @Autowired //Framework to auto instantiate this class
    private MovieRepository movieRepository; //Uses Repository class to talk to the database then returns to the API layer

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }
}
