package iuh.fit.se.movieservice.config;

import iuh.fit.se.movieservice.entity.Movie;
import iuh.fit.se.movieservice.entity.MovieStatus;
import iuh.fit.se.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DemoDataConfig {

    @Bean
    CommandLineRunner movieSeeder(
            MovieRepository movieRepository,
            @Value("${app.seed-data:true}") boolean seedData
    ) {
        return args -> {
            if (!seedData || movieRepository.count() > 0) {
                return;
            }

            // Seed mẫu để frontend có dữ liệu hiển thị ngay khi demo.
            movieRepository.saveAll(List.of(
                    Movie.builder()
                            .title("Avengers: Endgame")
                            .description("Biệt đội Avengers chiến đấu lần cuối để cứu vũ trụ.")
                            .duration(181)
                            .genre("Action")
                            .posterUrl("https://example.com/poster1.jpg")
                            .language("English")
                            .ageRating("PG-13")
                            .status(MovieStatus.ACTIVE)
                            .build(),
                    Movie.builder()
                            .title("Frozen 2")
                            .description("Cuộc phiêu lưu mới của Elsa và Anna trên hành trình tìm kiếm sự thật.")
                            .duration(103)
                            .genre("Animation")
                            .posterUrl("https://example.com/poster2.jpg")
                            .language("English")
                            .ageRating("P")
                            .status(MovieStatus.ACTIVE)
                            .build()
            ));
        };
    }
}
