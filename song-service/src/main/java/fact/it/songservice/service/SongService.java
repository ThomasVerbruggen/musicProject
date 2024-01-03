package fact.it.songservice.service;

import fact.it.songservice.model.Song;
import fact.it.songservice.repository.SongRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SongService {

    private final SongRepository songRepository;

    @PostConstruct
    public void loadData() {
        if (songRepository.count() == 0) {
            songRepository.save(new Song("Song 1", "Artist 1", 1));
            songRepository.save(new Song("Song 2", "Artist 2", 2));
            songRepository.save(new Song("Song 3", "Artist 3", 3));
        }
    }


    @Transactional(readOnly = true)
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Song findById(long id) throws Exception {
        return songRepository.findById(id);
    }
}
