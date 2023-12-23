package fact.it.albumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumResponse {
    private String albumId;
    private String skuCode;
    private String title;
    private String releaseDate;
    private int tracks;
    private Long artistId;
    private Long genreId;
}
