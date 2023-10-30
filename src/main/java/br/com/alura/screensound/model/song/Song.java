package br.com.alura.screensound.model.song;

import br.com.alura.screensound.model.artist.Artist;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Song")
@Table(name = "songs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private SongGenre genre;

    @ManyToOne
    private Artist artist;

    public Song(String title, SongGenre genre) {
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Título: " + this.getTitle()
                + " | Artista: " + this.getArtist().getName()
                + " | Gênero: " + this.getGenre();
    }
}
