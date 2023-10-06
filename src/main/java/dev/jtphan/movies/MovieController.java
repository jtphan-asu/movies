package dev.jtphan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    //Getting request from the User and Returning a response
    public ResponseEntity<List<Movie>> allMovies(){
        //Use MovieService to return all movies from MovieRepository. Then return '200' as HTTP status
       return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
}
