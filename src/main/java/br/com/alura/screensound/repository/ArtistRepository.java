package br.com.alura.screensound.repository;

import br.com.alura.screensound.model.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByNameIgnoreCase(String artistName);
}
