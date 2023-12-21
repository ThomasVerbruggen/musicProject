package fact.it.genreservice.repository;

import fact.it.genreservice.model.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByNameContaining(String name);
}
