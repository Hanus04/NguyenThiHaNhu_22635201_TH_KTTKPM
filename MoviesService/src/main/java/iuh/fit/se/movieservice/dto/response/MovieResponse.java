package iuh.fit.se.movieservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import iuh.fit.se.movieservice.entity.MovieStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResponse {

    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private String genre;
    private String posterUrl;
    private String language;
    private String ageRating;
    private MovieStatus status;
}
