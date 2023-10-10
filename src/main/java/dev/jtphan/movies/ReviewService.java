package dev.jtphan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    //Reference to Review Repository
    private ReviewRepository reviewRepository;

    @Autowired
    //Using a template can also talk to the database
    //without having to use the repository
    //This can take care of dynamic queries
    private MongoTemplate mongoTemplate;

    //Look for movie using imdbId, then create a review for it
    public Review createReview(String reviewBody, String imdbId) {
        Review review =  reviewRepository.insert(new Review(reviewBody));

        //Associate to one of the movies


        //Using the template to perform an update call on the Movie class
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

}
