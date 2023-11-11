package dev.jtphan.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    //Getting request from the User and Returning a response
    public ResponseEntity<List<Movie>> allMovies(){
        //Use MovieService to return all movies from MovieRepository. Then return '200' as HTTP status
       return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    //Lets Framework know that we are using Path Variable then converting to String imdbId
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {

        //Return a single movie instance using Path Variable and imdbId
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);

    }


}
