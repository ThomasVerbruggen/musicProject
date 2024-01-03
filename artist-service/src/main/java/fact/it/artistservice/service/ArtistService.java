package fact.it.artistservice.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fact.it.artistservice.dto.ArtistRequest;
import fact.it.artistservice.model.Artist;
import fact.it.artistservice.repository.ArtistRepository;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    @PostConstruct
    public void loadData() {
        if (artistRepository.count() <= 0) {
            Artist artist = new Artist();
            artist.setName("Test Artist");
            artist.setSkuCode("tube6in");
            artist.setBirthDate(null);
            artist.setCountryOfOrigin("Belgium");
            artist.setLabel("Test Label");
            artist.setIsActive(true);

            Artist artist1 = new Artist();
            artist1.setName("Test Artist1");
            artist1.setSkuCode("tube6in");
            artist1.setBirthDate(null);
            artist1.setCountryOfOrigin("America");
            artist1.setLabel("Test Label2");
            artist1.setIsActive(false);

            artistRepository.save(artist);
            artistRepository.save(artist1);
        }
    }

    @Transactional(readOnly = true)
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Transactional
    public void updateArtist(String artistId, ArtistRequest artistRequest) {
        Long artistIdLong;

        try {
            artistIdLong = Long.parseLong(artistId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid artistId format. Must be a number.");
        }

        Optional<Artist> existingArtistOptional = artistRepository.findById(artistIdLong);

        if (existingArtistOptional.isPresent()) {
            Artist existingArtist = existingArtistOptional.get();

            performUpdate(existingArtist, artistRequest);
        } else {
            throw new RuntimeException("Artist not found with ID: " + artistId);
        }
    }

    private void performUpdate(Artist existingArtist, ArtistRequest artistRequest) {
        existingArtist.setName(artistRequest.getName());
        existingArtist.setSkuCode(artistRequest.getSkuCode());
        existingArtist.setBirthDate(artistRequest.getBirthDate());
        existingArtist.setCountryOfOrigin(artistRequest.getCountryOfOrigin());
        existingArtist.setLabel(artistRequest.getLabel());
        existingArtist.setIsActive(artistRequest.getIsActive());

        artistRepository.save(existingArtist);
    }

    public void deleteArtist(Long artistId) {
        artistRepository.deleteById(artistId);
    }

    public Artist createArtist(ArtistRequest artistRequest) {
        Artist newArtist = new Artist();
        newArtist.setSkuCode(artistRequest.getSkuCode());
        newArtist.setName(artistRequest.getName());
        newArtist.setBirthDate(artistRequest.getBirthDate());
        newArtist.setCountryOfOrigin(artistRequest.getCountryOfOrigin());
        newArtist.setLabel(artistRequest.getLabel());
        newArtist.setIsActive(artistRequest.getIsActive());

        return artistRepository.save(newArtist);
    }

    public Artist getArtistById(long artistId) {
        Optional<Artist> artistOptional = artistRepository.findById(artistId);
        return artistOptional.orElse(null);
    }
}