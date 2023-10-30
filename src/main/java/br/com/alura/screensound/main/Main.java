package br.com.alura.screensound.main;

import br.com.alura.screensound.model.artist.Artist;
import br.com.alura.screensound.model.artist.ArtistType;
import br.com.alura.screensound.model.song.Song;
import br.com.alura.screensound.model.song.SongGenre;
import br.com.alura.screensound.repository.ArtistRepository;
import br.com.alura.screensound.repository.SongRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public Main(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    public void showMenu() {
        System.out.println("**** SCREEN SOUND MÚSICAS ****");
        showOperations();
    }

    private void showOperations() {
        int option = -1;
        while (option != 0) {
            System.out.println("""
                1- Cadastrar artistas
                2- Cadastrar músicas
                3- Listar músicas
                4- Buscar músicas por artista
                0- Sair do programa
                """);

            System.out.print("Escolha entre as opções acima: ");
            option = scanner.nextInt();
            scanner.nextLine();
            callOperations(option);
        }
    }

    private void callOperations(int option) {
        switch (option) {
            case 1 -> registerArtist();
            case 2 -> registerSong();
            case 3 -> listAllSongs();
            case 4 -> searchByArtist();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Erro! Opção inválida!");
        }

        System.out.println("----------------------------------------");
    }

    private void registerArtist() {
        System.out.println("**** CADASTRO DE ARTISTA ****");
        boolean willContinue = true;
        while (willContinue) {
            Artist artist = setArtistInfo();
            artistRepository.save(artist);
            System.out.print("Deseja cadastrar mais artistas [S/N]? ");
            willContinue = !scanner.nextLine().equalsIgnoreCase("n");
        }
    }

    private void registerSong() {
        System.out.println("**** CADASTRO DE MÚSICA ****");
        boolean willContinue = true;
        while (willContinue) {
            Song song = setSongInfo();
            songRepository.save(song);
            System.out.print("Deseja cadastrar mais músicas [S/N]? ");
            willContinue = !scanner.nextLine().equalsIgnoreCase("n");
        }
    }

    private void listAllSongs() {
        System.out.println("Listagem de músicas");
    }

    private void searchByArtist() {
        System.out.println("Busca de músicas por artista");
    }

    private void listRegisteredArtists() {
        List<Artist> registeredArtists = artistRepository.findAll();
        registeredArtists.forEach(a -> System.out.println(a.getName()));
    }

    private String setArtistName() {
        System.out.print("Digite o nome do artista: ");
        return scanner.nextLine();
    }

    private Artist setArtistInfo() {
        String name = setArtistName();
        System.out.print("Digite o tipo do artista (SOLO, GRUPO, BANDA, DUPLA): ");
        ArtistType type = ArtistType.valueOf(scanner.nextLine().toUpperCase());

        return new Artist(name, type);
    }

    private Song setSongInfo() {
        System.out.println("Artistas Cadastrados:");
        listRegisteredArtists();
        String artistName = setArtistName();
        Optional<Artist> artist = artistRepository.findByNameIgnoreCase(artistName);

        while (artist.isEmpty()) {
            System.out.println("Artista não encontrado! Tente novamente!");
            artistName = setArtistName();
            artist = artistRepository.findByNameIgnoreCase(artistName);
        }

        System.out.print("Digite o nome da música: ");
        String title = scanner.nextLine();
        System.out.print("Digite o gênero da música: ");
        SongGenre genre = SongGenre.valueOf(scanner.nextLine().toUpperCase());

        Song song = new Song(title, genre);
        artist.get().addSong(song);

        return song;
    }
}
