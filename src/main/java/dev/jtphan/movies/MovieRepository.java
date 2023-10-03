package dev.jtphan.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //Lets framework know that this interface is a repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
}
