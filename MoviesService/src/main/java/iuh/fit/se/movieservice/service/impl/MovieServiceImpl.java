package iuh.fit.se.movieservice.service.impl;

import iuh.fit.se.movieservice.dto.request.CreateMovieRequest;
import iuh.fit.se.movieservice.dto.response.MovieResponse;
import iuh.fit.se.movieservice.entity.Movie;
import iuh.fit.se.movieservice.exception.MovieCreationException;
import iuh.fit.se.movieservice.mapper.MovieMapper;
import iuh.fit.se.movieservice.repository.MovieRepository;
import iuh.fit.se.movieservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAllByOrderByCreatedAtDescIdDesc()
                .stream()
                .map(movieMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public MovieResponse createMovie(CreateMovieRequest request) {
        try {
            Movie movie = movieMapper.toEntity(request);
            Movie savedMovie = movieRepository.saveAndFlush(movie);
            return movieMapper.toResponse(savedMovie);
        } catch (DataAccessException exception) {
            throw new MovieCreationException("Không thêm được phim vào hệ thống", exception);
        }
    }
}
