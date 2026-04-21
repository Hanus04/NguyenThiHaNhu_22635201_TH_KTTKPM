package iuh.fit.se.movieservice.service;

import iuh.fit.se.movieservice.dto.request.CreateMovieRequest;
import iuh.fit.se.movieservice.dto.response.MovieResponse;

import java.util.List;

public interface MovieService {

    List<MovieResponse> getAllMovies();

    MovieResponse createMovie(CreateMovieRequest request);
}
