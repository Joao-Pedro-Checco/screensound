package br.com.alura.screensound.main;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

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
        System.out.println("Cadastro de artista");
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
}
