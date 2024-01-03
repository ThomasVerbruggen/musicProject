package fact.it.songservice.repository;

import fact.it.songservice.model.Song;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAll();

    Song findById(long id);
}