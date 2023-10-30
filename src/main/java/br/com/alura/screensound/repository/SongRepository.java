package br.com.alura.screensound.repository;

import br.com.alura.screensound.model.artist.Artist;
import br.com.alura.screensound.model.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByArtist(Artist artist);
}
