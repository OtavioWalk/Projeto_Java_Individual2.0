package school.sptech;

import java.util.Scanner;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.time.Instant;
import java.time.ZoneId;


import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        RegistroDAO registroDAO = new RegistroDAO("jdbc:mysql://localhost:3306/java?serverTimezone=America/Sao_Paulo", "root", "sptech");
        Scanner scanner = new Scanner(System.in);
        Authentication authentication = new Authentication();

        while (true) {
            System.out.println("Bem-vindo! Digite seu nome de usuário: ");
            String username = scanner.nextLine();
            System.out.println("Digite sua senha: ");
            String password = scanner.nextLine();

            User user = authentication.authenticate(username, password);

            while (true) {
                if (user != null) {
                    System.out.println("Login bem-sucedido!");
                    System.out.println("Menu Principal:");
                    System.out.println("1. Captura de Dados");
                    System.out.println("2. Sair da Aplicação");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Capturando dados...");
                            Looca looca = new Looca();
                            Sistema sistema = looca.getSistema();

                            // Coleta os dados do Looca
                            String sistemaOperacional = sistema.getSistemaOperacional();
                            String fabricante = sistema.getFabricante();
                            String arquitetura = String.valueOf(sistema.getArquitetura());
                            Instant inicializadoInstant = sistema.getInicializado();

                            // Converte Instant para LocalDateTime
                            LocalDateTime inicializado = inicializadoInstant.atZone(ZoneId.systemDefault()).toLocalDateTime();

                            // Cria uma instância da classe Registro
                            Registro registro = new Registro();
                            registro.setSistemaOperacional(sistemaOperacional);
                            registro.setFabricante(fabricante);
                            registro.setArquitetura(arquitetura);
                            registro.setInicializado(inicializado);
                            registro.setNome(user.getUsername());

                            // Insere os dados no banco de dados usando RegistroDAO
                            registroDAO.inserirRegistro(registro);


                            System.out.println("Dados capturados e inseridos na tabela 'registro'.");
                            break;
                        case 2:
                            System.out.println("Saindo da aplicação.");
                            System.exit(0);
                    }
                } else {
                    System.out.println("Falha na autenticação. Tente novamente.");
                }
            }
        }
    }
}
