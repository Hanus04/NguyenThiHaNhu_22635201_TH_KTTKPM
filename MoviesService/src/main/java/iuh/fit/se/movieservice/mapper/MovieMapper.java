package iuh.fit.se.movieservice.mapper;

import iuh.fit.se.movieservice.dto.request.CreateMovieRequest;
import iuh.fit.se.movieservice.dto.response.MovieResponse;
import iuh.fit.se.movieservice.entity.Movie;
import iuh.fit.se.movieservice.entity.MovieStatus;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie toEntity(CreateMovieRequest request) {
        return Movie.builder()
                .title(trim(request.getTitle()))
                .description(trim(request.getDescription()))
                .duration(request.getDuration())
                .genre(trim(request.getGenre()))
                .posterUrl(trim(request.getPosterUrl()))
                .language(trim(request.getLanguage()))
                .ageRating(trim(request.getAgeRating()))
                .status(request.getStatus() == null ? MovieStatus.ACTIVE : request.getStatus())
                .build();
    }

    public MovieResponse toResponse(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .duration(movie.getDuration())
                .genre(movie.getGenre())
                .posterUrl(movie.getPosterUrl())
                .language(movie.getLanguage())
                .ageRating(movie.getAgeRating())
                .status(movie.getStatus())
                .build();
    }

    private String trim(String value) {
        return value == null ? null : value.trim();
    }
}
