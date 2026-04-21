package iuh.fit.se.movieservice.dto.request;

import iuh.fit.se.movieservice.entity.MovieStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieRequest {

    @NotBlank(message = "Tiêu đề phim không được để trống")
    @Size(max = 255, message = "Tiêu đề phim không được vượt quá 255 ký tự")
    private String title;

    @NotBlank(message = "Mô tả phim không được để trống")
    @Size(max = 2000, message = "Mô tả phim không được vượt quá 2000 ký tự")
    private String description;

    @NotNull(message = "Thời lượng phim là bắt buộc")
    @Positive(message = "Thời lượng phim phải lớn hơn 0")
    private Integer duration;

    @NotBlank(message = "Thể loại phim không được để trống")
    @Size(max = 100, message = "Thể loại phim không được vượt quá 100 ký tự")
    private String genre;

    @Size(max = 500, message = "Poster URL không được vượt quá 500 ký tự")
    private String posterUrl;

    @Size(max = 100, message = "Ngôn ngữ không được vượt quá 100 ký tự")
    private String language;

    @Size(max = 50, message = "Giới hạn độ tuổi không được vượt quá 50 ký tự")
    private String ageRating;

    private MovieStatus status;
}
