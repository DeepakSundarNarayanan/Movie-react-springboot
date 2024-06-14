package dev.deepak.movies.Service;

import dev.deepak.movies.Movie;
import dev.deepak.movies.Repository.MovieInterface;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieInterface movieInterface;
    public List<Movie> allMovies(){
        return movieInterface.findAll();

    }

    public Optional<Movie> getMovieById(String imdbId){
        return movieInterface.findByImdbId(imdbId);
    }


}
