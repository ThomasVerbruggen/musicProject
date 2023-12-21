package fact.it.artistservice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fact.it.artistservice.model.Artist;

import java.util.List;

@Repository
@Transactional
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findBySkuCodeIn(List<String> skuCode);
}