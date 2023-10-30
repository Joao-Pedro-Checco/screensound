package br.com.alura.screensound.main;

import br.com.alura.screensound.model.artist.Artist;
import br.com.alura.screensound.model.artist.ArtistType;
import br.com.alura.screensound.repository.ArtistRepository;
import br.com.alura.screensound.repository.SongRepository;

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
        System.out.println("Cadastro de música");
    }

    private void listAllSongs() {
        System.out.println("Listagem de músicas");
    }

    private void searchByArtist() {
        System.out.println("Busca de músicas por artista");
    }

    private Artist setArtistInfo() {
        System.out.print("Digite o nome do artista: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo do artista (SOLO, GRUPO, BANDA, DUPLA): ");
        ArtistType tipo = ArtistType.valueOf(scanner.nextLine().toUpperCase());

        return new Artist(nome, tipo);
    }
}
