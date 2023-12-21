package fact.it.genreservice.service;

import fact.it.genreservice.model.Genre;
import fact.it.genreservice.repository.GenreRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    
    private final GenreRepository genreRepository;

    @PostConstruct
    public void loadData() {
        if (genreRepository.count() == 0) {
            // create new genres of music
            Genre genre1 = new Genre();
            genre1.setName("Rock");
            genre1.setDescription("Rock music");
            genre1.setSkuCode("ROCK");
            genreRepository.save(genre1);
            // add second genre
            Genre genre2 = new Genre();
            genre2.setName("Pop");
            genre2.setDescription("Pop music");
            genre2.setSkuCode("POP");
            genreRepository.save(genre2);
            // add third genre
            Genre genre3 = new Genre();
            genre3.setName("Jazz");
            genre3.setDescription("Jazz music");
            genre3.setSkuCode("JAZZ");
            genreRepository.save(genre3);
        }
    }

    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }
}
