package dev.jtphan.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//This is where most Business Logic will go
public class MovieService {
    @Autowired //Framework to auto instantiate this class
    private MovieRepository movieRepository; //Uses Repository class to talk to the database then returns to the API layer

    //Return all movies from Database
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    //Return a single movie based on imdbId in database
    public Optional<Movie> singleMovie(String imdbIb){
        return movieRepository.findMovieByImdbId(imdbIb);
    }
}
