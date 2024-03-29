package fact.it.songservice;

import fact.it.songservice.repository.SongRepository;
import fact.it.songservice.service.SongService;
import fact.it.songservice.model.Song;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SongServiceApplicationTests {

	@InjectMocks
	private SongService songService;

	@Mock
	private SongRepository songRepository;

	@Test
	public void testGetSongs() {
		Song song1 = new Song(1L, "song1", "artist1", 2022);
		Song song2 = new Song(2L, "song2", "artist2", 2023);
		List<Song> songs = Arrays.asList(song1, song2);

		when(songRepository.findAll()).thenReturn(songs);

		List<Song> result = songService.findAll();

		assertEquals(2, result.size());
		assertEquals(song1, result.get(0));
		assertEquals(song2, result.get(1));
	}

}
