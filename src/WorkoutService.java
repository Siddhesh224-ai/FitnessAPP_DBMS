import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkoutService {
    public static void logWorkout(long workoutId, long userId, String date) {
        String sql = "INSERT INTO workout (workout_id, user_id, date) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, workoutId);
            stmt.setLong(2, userId);
            stmt.setString(3, date);

            stmt.executeUpdate();
            System.out.println("Workout logged successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addExerciseToWorkout(long workoutId, long exerciseId, int reps, int sets) {
        String sql = "INSERT INTO workout_exercise (workout_id, exercise_id, reps, sets) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, workoutId);
            stmt.setLong(2, exerciseId);
            stmt.setInt(3, reps);
            stmt.setInt(4, sets);

            stmt.executeUpdate();
            System.out.println("Exercise added to workout.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
