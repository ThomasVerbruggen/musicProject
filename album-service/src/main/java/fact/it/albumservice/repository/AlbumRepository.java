package fact.it.albumservice.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import fact.it.albumservice.model.Album;

public interface AlbumRepository extends MongoRepository<Album, String> {
    List<Album> findBySkuCodeIn(List<String> skuCode);
}