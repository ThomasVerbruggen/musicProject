package fact.it.albumservice.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fact.it.albumservice.dto.AlbumRequest;
import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.model.Album;
import fact.it.albumservice.repository.AlbumRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    @PostConstruct
    public void loadData() {
        if (albumRepository.count() <= 0) {
            Album album = new Album();
            album.setSkuCode("tube6in");
            album.setTitle("6 in the tube");
            album.setReleaseDate("2021-01-03");
            album.setTracks(6);
            album.setArtistId(1L);
            album.setGenreId(1L);
            albumRepository.save(album);

            album = new Album();
            album.setSkuCode("tube6out");
            album.setTitle("6 out the tube");
            album.setReleaseDate("2021-01-01");
            album.setTracks(6);
            album.setArtistId(1L);
            album.setGenreId(1L);
            albumRepository.save(album);

            album = new Album();
            album.setSkuCode("tube7in");
            album.setTitle("7 in the tube");
            album.setReleaseDate("2020-01-01");
            album.setTracks(7);
            album.setArtistId(1L);
            album.setGenreId(1L);
            albumRepository.save(album);
        }
    }

    public void createAlbum(AlbumRequest albumRequest) {
        Album album = Album.builder()
                .skuCode(albumRequest.getSkuCode())
                .title(albumRequest.getTitle())
                .releaseDate(albumRequest.getReleaseDate())
                .tracks(albumRequest.getTracks())
                .artistId(albumRequest.getArtistId())
                .genreId(albumRequest.getGenreId())
                .build();
        albumRepository.save(album);
    }

    public List<AlbumResponse> getAllAlbums() {
        return null;
    }
}
