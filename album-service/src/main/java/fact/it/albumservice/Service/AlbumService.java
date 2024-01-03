package fact.it.albumservice.Service;

import java.util.List;

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
            Album album = Album.builder()
                    .skuCode("tube1")
                    .title("1 in the tube")
                    .releaseDate("2020-01-01")
                    .tracks(1)
                    .artistId("1L")
                    .genreId("1L")
                    .build();

            Album album1 = Album.builder()
                    .skuCode("tube2")
                    .title("2 in the tube")
                    .releaseDate("2020-01-01")
                    .tracks(2)
                    .artistId("2L")
                    .genreId("2L")
                    .build();

            albumRepository.save(album);
            albumRepository.save(album1);
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
        List<Album> albums = albumRepository.findAll();

        return albums.stream().map(this::mapToAlbumResponse).toList();
    }

    private AlbumResponse mapToAlbumResponse(Album album) {
        return AlbumResponse.builder()
                .albumId(album.getAlbumId())
                .skuCode(album.getSkuCode())
                .title(album.getTitle())
                .releaseDate(album.getReleaseDate())
                .tracks(album.getTracks())
                .artistId(album.getArtistId())
                .genreId(album.getGenreId())
                .build();
    }

    public void updateAlbum(String albumId, AlbumRequest albumRequest) {
        Album existingAlbum = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album not found"));

        existingAlbum.setSkuCode(albumRequest.getSkuCode());
        existingAlbum.setTitle(albumRequest.getTitle());
        existingAlbum.setReleaseDate(albumRequest.getReleaseDate());
        existingAlbum.setTracks(albumRequest.getTracks());
        existingAlbum.setArtistId(albumRequest.getArtistId());
        existingAlbum.setGenreId(albumRequest.getGenreId());

        albumRepository.save(existingAlbum);
    }

    public void deleteAlbum(String albumId) {
        albumRepository.deleteById(albumId);
    }
}
