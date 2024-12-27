import java.util.ArrayList;
import java.util.Scanner;

public class App {

        private static List<Livro> livros = new ArrayList<> ();//lista para armazenar os livros.
        private static List<Emprestimo> emprestimo = new ArrayList<>(); //lista para armazenar os emprestimos
        private static  List <Usuario> usuario = new ArrayList<>(); //lista de usuarios
    }
public static void main (String[]args){
    Scanner scanner = new Scanner (System.in);
    int opcao = -1;


while (opcao != 0){
    System.out.println("SISTEMA BIBLIOTECA");
    System.out.println("Cadastrar livro");
    System.out.println("Cadastrar usuário");
    System.out.println("Listar livros cadastrados");
    System.out.println("Listar livros emprestados e disponiveis");
    System.out.println("Listar histórico de emprestimos");
    System.out.println("Realizar emprestimo");
    System.out.println("Devolver livro");
    System.out.println("Sair do programa");
    System.out.println("Digite uma das opções acima:");
}}