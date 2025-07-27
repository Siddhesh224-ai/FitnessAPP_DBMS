import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FrequentQueries {
    public static void mostFrequentExercise(long userId) {
        String sql = """
            SELECT e.name, COUNT(*) AS freq
            FROM workout_exercise we
            JOIN exercise e ON we.exercise_id = e.exercise_id
            JOIN workout w ON we.workout_id = w.workout_id
            WHERE w.user_id = ?
            GROUP BY e.name
            ORDER BY freq DESC
            LIMIT 1
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Most frequent exercise: " + rs.getString("name") +
                            " (done " + rs.getInt("freq") + " times)");
                } else {
                    System.out.println("No workouts found.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
