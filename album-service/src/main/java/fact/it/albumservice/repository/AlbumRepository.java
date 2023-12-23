package fact.it.albumservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fact.it.albumservice.model.Album;

@Repository
@Transactional
public interface AlbumRepository extends MongoRepository<Album, String> {
    List<Album> findBySkuCodeIn(List<String> skuCode);
}