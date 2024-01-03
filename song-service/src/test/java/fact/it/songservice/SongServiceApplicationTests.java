package fact.it.songservice;

import fact.it.songservice.repository.SongRepository;
import fact.it.songservice.service.SongService;
import fact.it.songservice.model.Song;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SongServiceApplicationTests {

	@InjectMocks
	private SongService songService;

	@Mock
	private SongRepository songRepository;

}
