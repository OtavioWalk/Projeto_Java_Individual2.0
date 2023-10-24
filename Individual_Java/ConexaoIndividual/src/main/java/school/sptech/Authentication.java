package school.sptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Authentication {
    public User authenticate(String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?serverTimezone=America/Sao_Paulo", "root", "sptech");
            String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("nome_usuario"), resultSet.getString("senha"));
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("nome_usuario"));
                user.setPassword(resultSet.getString("senha"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

