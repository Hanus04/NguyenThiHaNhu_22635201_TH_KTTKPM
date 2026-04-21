package iuh.fit.se.movieservice.controller;

import iuh.fit.se.movieservice.dto.request.CreateMovieRequest;
import iuh.fit.se.movieservice.dto.response.ApiResponse;
import iuh.fit.se.movieservice.dto.response.MovieResponse;
import iuh.fit.se.movieservice.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<MovieResponse>>> getMovies() {
        List<MovieResponse> movies = movieService.getAllMovies();
        String message = movies.isEmpty() ? "Không có phim nào" : "Lấy danh sách phim thành công";

        return ResponseEntity.ok(ApiResponse.success(message, movies));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MovieResponse>> createMovie(@Valid @RequestBody CreateMovieRequest request) {
        MovieResponse createdMovie = movieService.createMovie(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Thêm phim thành công", createdMovie));
    }
}
