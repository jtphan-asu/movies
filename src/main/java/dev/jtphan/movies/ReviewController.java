package dev.jtphan.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    //What we get as RequestBody we would like to convert into a Map of Key String and Value String called payload
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        //Receive JSON endpoint data from user then convert to a Map
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),
                payload.get("imdbId")), HttpStatus.CREATED);
    }

    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    //Create a new Review
    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        //Update MongoDB
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
