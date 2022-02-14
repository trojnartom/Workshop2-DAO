package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO users (username, email, password) VALUES (?, ?, ?) ";
    private static final String CHANGE_USER_QUERY = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
    private static final String FIND_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM users";

    public User create (User user) {
        try (Connection conn = DBUtil.connect("users_ws")){
            PreparedStatement createStmt = conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            createStmt.setString(1, user.getUserName());
            createStmt.setString(2, user.getEmail());
            createStmt.setString(3, user.getPassword());
            createStmt.executeUpdate();
            ResultSet rs = createStmt.getGeneratedKeys();
            if(rs.next()) {
                user.setId(rs.getInt(1));
            }
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User read (int userId) {
        try (Connection conn = DBUtil.connect("users_ws")) {
            PreparedStatement reedStmt = conn.prepareStatement(FIND_USER_BY_ID_QUERY);
            reedStmt.setString(1, String.valueOf(userId));
            ResultSet rs = reedStmt.executeQuery();
            if (rs.next()) {
                String userName = rs.getString("username");
                String userEmail = rs.getString("email");
                String userPass = rs.getString("password");
                System.out.printf("%d: User: %s -- E-mail: %s -- Password: %s", userId, userName, userEmail, userPass);
            } else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update (User user) {
        try (Connection conn = DBUtil.connect("users_ws")) {
            PreparedStatement updateStmt = conn.prepareStatement(CHANGE_USER_QUERY);
            updateStmt.setString(1, user.getUserName() );
            updateStmt.setString(2, user.getEmail() );
            updateStmt.setString(3, user.getPassword());
            updateStmt.setString(4, String.valueOf(user.getId()));
            updateStmt.executeUpdate();
            System.out.println("User updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
