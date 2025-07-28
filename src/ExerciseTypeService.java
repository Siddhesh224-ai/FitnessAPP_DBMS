import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExerciseTypeService {
    public static void addType(long typeId, String name) {
        String sql = "INSERT INTO exercise_type (type_id, name) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, typeId);
            stmt.setString(2, name);

            stmt.executeUpdate();
            System.out.println("Exercise type added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
