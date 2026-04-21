package iuh.fit.se.movieservice;

import iuh.fit.se.movieservice.entity.Movie;
import iuh.fit.se.movieservice.entity.MovieStatus;
import iuh.fit.se.movieservice.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        movieRepository.deleteAll();
    }

    @Test
    void getMoviesShouldReturnEmptyListWhenNoData() throws Exception {
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Không có phim nào"))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data.length()").value(0));
    }

    @Test
    void getMoviesShouldReturnMoviesOrderedByCreatedAtDesc() throws Exception {
        movieRepository.save(Movie.builder()
                .title("Older Movie")
                .description("Older description")
                .duration(100)
                .genre("Drama")
                .status(MovieStatus.ACTIVE)
                .build());

        movieRepository.save(Movie.builder()
                .title("Latest Movie")
                .description("Latest description")
                .duration(120)
                .genre("Action")
                .status(MovieStatus.ACTIVE)
                .build());

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Lấy danh sách phim thành công"))
                .andExpect(jsonPath("$.data[0].title").value("Latest Movie"))
                .andExpect(jsonPath("$.data[1].title").value("Older Movie"));
    }

    @Test
    void createMovieShouldReturnCreatedMovie() throws Exception {
        String request = """
                {
                  "title": "Avengers: Endgame",
                  "description": "Biệt đội Avengers chiến đấu lần cuối",
                  "duration": 181,
                  "genre": "Action",
                  "posterUrl": "https://example.com/poster.jpg"
                }
                """;

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Thêm phim thành công"))
                .andExpect(jsonPath("$.data.title").value("Avengers: Endgame"))
                .andExpect(jsonPath("$.data.status").value("ACTIVE"));
    }

    @Test
    void createMovieShouldReturnBadRequestWhenValidationFails() throws Exception {
        String request = """
                {
                  "title": " ",
                  "description": "",
                  "duration": 0,
                  "genre": " "
                }
                """;

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Dữ liệu request không hợp lệ"))
                .andExpect(jsonPath("$.errors.title").exists())
                .andExpect(jsonPath("$.errors.description").exists())
                .andExpect(jsonPath("$.errors.duration").exists())
                .andExpect(jsonPath("$.errors.genre").exists());
    }
}
