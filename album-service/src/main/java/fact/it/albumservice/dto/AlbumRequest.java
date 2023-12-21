package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumRequest {
    private String skuCode;
    private String title;
    private int tracks;
    private String releaseDate;
    private Long artistId;
    private Long genreId;
}
