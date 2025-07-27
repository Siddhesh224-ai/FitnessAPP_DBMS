import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExerciseService {
    public static void addExercise(long id, long typeId, String name) {
        String sql = "INSERT INTO exercise (exercise_id, type_id, name) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.setLong(2, typeId);
            stmt.setString(3, name);

            stmt.executeUpdate();
            System.out.println("Exercise added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
