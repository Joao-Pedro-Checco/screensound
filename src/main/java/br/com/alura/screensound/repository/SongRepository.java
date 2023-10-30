package br.com.alura.screensound.repository;

import br.com.alura.screensound.model.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
