package dev.jtphan.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.List;

@Document(collection = "movies") //Refers to Document of
// collection movies in MovieAPI
@Data //takes care of getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id //Creates unique entities for database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;

    @DocumentReference
    //Causes the Database to only store Ids of review
    //Reviews will be in a separate collection
    //One movie can have many reviews
    private List<Review> reviewIds;


}
