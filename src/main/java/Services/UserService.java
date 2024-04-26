package Services;

import Entite.User;
import Utils.DataSource;

import java.sql.*;

public class UserService {

    private Connection con= DataSource.getInstance().getCon();
    private Statement ste;


    public boolean login(User user) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean signUp(User user) {
        String query = "INSERT INTO users (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
