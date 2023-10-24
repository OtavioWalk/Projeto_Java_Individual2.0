package school.sptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroDAO {
    private String url;
    private String usuario;
    private String senha;

    public RegistroDAO(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void inserirRegistro(Registro registro) {
        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "INSERT INTO registro (sistemaOperacional, fabricante, arquitetura, inicializado, nome) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, registro.getSistemaOperacional());
            preparedStatement.setString(2, registro.getFabricante());
            preparedStatement.setString(3, registro.getArquitetura());
            preparedStatement.setObject(4, registro.getInicializado());
            preparedStatement.setString(5, registro.getNome());

            preparedStatement.executeUpdate();
            System.out.println("Dados inseridos com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

