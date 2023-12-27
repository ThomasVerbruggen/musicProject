package fact.it.artistservice.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }
}