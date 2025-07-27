import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserService {
    public static void addUser(long id, String email, String passwordHash, String name, int age, String gender) {
        String sql = "INSERT INTO User (user_id, email, password_hash, name, age, gender, created_at) VALUES (?, ?, ?, ?, ?, ?, NOW())";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.setString(2, email);
            stmt.setString(3, passwordHash);
            stmt.setString(4, name);
            stmt.setInt(5, age);
            stmt.setString(6, gender);

            stmt.executeUpdate();
            System.out.println("User added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
