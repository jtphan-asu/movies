package dev.jtphan.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //Lets framework know that this interface is a repository
//This class serves as the data access layer since it talks to the MongoDB database
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //Optional because it may return null
    Optional<Movie> findMovieByImdbId(String imdbId);
}
