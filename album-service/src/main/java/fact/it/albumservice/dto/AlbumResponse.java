package fact.it.albumservice.dto;

import fact.it.albumservice.model.Album;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumResponse {

    public AlbumResponse(Album album) {
    }

    private String albumId;
    private String skuCode;
    private String title;
    private String releaseDate;
    private int tracks;
    private String artistId;
    private String genreId;
}
