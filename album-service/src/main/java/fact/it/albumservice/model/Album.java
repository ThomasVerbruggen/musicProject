package fact.it.albumservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "album")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Album {
    @Id
    private Long albumId;
    private String skuCode;
    private String title;
    private String releaseDate;
    private int tracks;
    private Long artistId;
    private Long genreId;

    public Long getId() {
        return albumId;
    }

    public void setId(Long albumId) {
        this.albumId = albumId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String sku) {
        this.skuCode = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }
}