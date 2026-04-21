package iuh.fit.se.movieservice.repository;

import iuh.fit.se.movieservice.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByOrderByCreatedAtDescIdDesc();
}
