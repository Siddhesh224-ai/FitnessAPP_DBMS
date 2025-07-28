import java.sql.*;

public class WorkoutService {
    public static long logWorkout(long userId, String workoutDate) {
        String sql = "INSERT INTO workout (user_id, date) VALUES (?, ?)";
        long generatedWorkoutId = -1;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setLong(1, userId);
            pstmt.setDate(2, Date.valueOf(workoutDate)); // Ensure workoutDate is "YYYY-MM-DD" format
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                generatedWorkoutId = rs.getLong(1);
                System.out.println("Workout logged successfully with ID: " + generatedWorkoutId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedWorkoutId;
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
