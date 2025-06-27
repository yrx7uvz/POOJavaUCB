import java.util.Scanner;

public class AplicacaoPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // criação dos contatos
        Contato contato1 = new Contato();
        Contato contato2 = new Contato();
        Contato contato3 = new Contato();
        
        // dados 1o contato
        System.out.println("=== Cadastro do Contato 1 ===");
        System.out.print("Nome: ");
        contato1.setNome(scanner.nextLine());
        System.out.print("Telefone: ");
        contato1.setTelefone(scanner.nextLine());
        
        // dados 2o contato
        System.out.println("\n=== Cadastro do Contato 2 ===");
        System.out.print("Nome: ");
        contato2.setNome(scanner.nextLine());
        System.out.print("Telefone: ");
        contato2.setTelefone(scanner.nextLine());
        
        // dados 3o contato
        System.out.println("\n=== Cadastro do Contato 3 ===");
        System.out.print("Nome: ");
        contato3.setNome(scanner.nextLine());
        System.out.print("Telefone: ");
        contato3.setTelefone(scanner.nextLine());
        
        // dados dos contatos
        System.out.println("\n=== Contatos Cadastrados ===");
        System.out.println("Contato 1: " + contato1.getNome() + " - " + contato1.getTelefone());
        System.out.println("Contato 2: " + contato2.getNome() + " - " + contato2.getTelefone());
        System.out.println("Contato 3: " + contato3.getNome() + " - " + contato3.getTelefone());
        
        // modificando os dados dos contatos
        System.out.println("\n=== Modificando Contatos ===");
        
        System.out.println("\nAtualizando Contato 1:");
        System.out.print("Novo nome: ");
        contato1.setNome(scanner.nextLine());
        System.out.print("Novo telefone: ");
        contato1.setTelefone(scanner.nextLine());
        
        System.out.println("\nAtualizando Contato 2:");
        System.out.print("Novo nome: ");
        contato2.setNome(scanner.nextLine());
        System.out.print("Novo telefone: ");
        contato2.setTelefone(scanner.nextLine());
        
        System.out.println("\nAtualizando Contato 3:");
        System.out.print("Novo nome: ");
        contato3.setNome(scanner.nextLine());
        System.out.print("Novo telefone: ");
        contato3.setTelefone(scanner.nextLine());
        
        // dados atualizados
        System.out.println("\n=== Contatos Atualizados ===");
        System.out.println("Contato 1: " + contato1.getNome() + " - " + contato1.getTelefone());
        System.out.println("Contato 2: " + contato2.getNome() + " - " + contato2.getTelefone());
        System.out.println("Contato 3: " + contato3.getNome() + " - " + contato3.getTelefone());
        
        scanner.close();
    }
}