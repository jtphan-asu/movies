package dev.jtphan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired //Framework to auto instantiate this class
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }
}
