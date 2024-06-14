package dev.deepak.movies.Service;

import dev.deepak.movies.Movie;
import dev.deepak.movies.Repository.ReviewRepository;
import dev.deepak.movies.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String body, String imdbId) {

        Reviews review = new Reviews(body);
        reviewRepository.insert(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds", review))
                .first();

        return review;





    }
}
