package org.example;

import br.com.desafio.dominio.Bootcamp;
import br.com.desafio.dominio.Curso;
import br.com.desafio.dominio.Dev;
import br.com.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        Curso curso = new Curso();
        curso.setTitulo("Curso de Java");
        curso.setDescricao("Curso de Java do João");
        curso.setCargaHoraria(120);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Mentoria de Java do João");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Bootcamp Java Developer do João");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);

        Dev devJoao = new Dev();
        devJoao.setNome("João");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Exibir Conteúdos Disponíveis");
            System.out.println("2. Inscrever-se no Bootcamp");
            System.out.println("3. Progredir no Bootcamp");
            System.out.println("4. Exibir Conteúdos Inscritos e Concluídos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("\n--- Conteúdos Disponíveis ---");
                    System.out.println("Curso: " + curso.getTitulo() + " - Carga Horária: " + curso.getCargaHoraria() + "h");
                    System.out.println("Mentoria: " + mentoria.getTitulo() + " - Data: " + mentoria.getData());
                    System.out.println("Bootcamp: " + bootcamp.getNome() + " - Descrição: " + bootcamp.getDescricao());
                    break;
                case 2:
                    if (devJoao.getConteudosInscritos().isEmpty()) {
                        System.out.println("\nInscrito no Bootcamp: " + bootcamp.getNome());
                        devJoao.inscreverBootcamp(bootcamp);
                        System.out.println("Conteúdos inscritos: " + devJoao.getConteudosInscritos());
                    } else {
                        System.out.println("\nVocê já está inscrito em um bootcamp.");
                    }
                    break;
                case 3:
                    if (!devJoao.getConteudosInscritos().isEmpty()) {
                        System.out.println("\nProgredindo no Bootcamp...");
                        devJoao.progredir();
                        System.out.println("Conteúdos inscritos após progredir: " + devJoao.getConteudosInscritos());
                        System.out.println("Conteúdos concluídos após progredir: " + devJoao.getConteudosConcluidos());
                        System.out.println("XP Total: " + devJoao.calcularTotalXp());
                    } else {
                        System.out.println("\nVocê precisa se inscrever em um bootcamp primeiro.");
                    }
                    break;
                case 4:
                    System.out.println("\n--- Conteúdos de " + devJoao.getNome() + " ---");
                    System.out.println("Conteúdos Inscritos: " + devJoao.getConteudosInscritos());
                    System.out.println("Conteúdos Concluídos: " + devJoao.getConteudosConcluidos());
                    System.out.println("XP Total: " + devJoao.calcularTotalXp());
                    break;
                case 0:
                    System.out.println("\nSaindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }
}