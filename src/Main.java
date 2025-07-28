import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            DatabaseMetaData meta = conn.getMetaData();

            boolean userExists = tableExists(meta, "user");
            boolean exerciseExists = tableExists(meta, "exercise");
            boolean workoutExists = tableExists(meta, "workout");
            boolean typeExists = tableExists(meta, "exercise_type");

            if (!userExists || !exerciseExists || !workoutExists || !typeExists) {
                GymDatabaseInitializer.createTables(conn);
                System.out.println("✅ Created tables because one or more were missing.");
            } else {
                System.out.println("📦 All core tables exist. Skipping schema creation.");
            }
            // Add sample data
            System.out.println("\n➡️ Inserting sample data...");

            // Add users
            UserService.addUser(1, "john@example.com", "hash123", "John", 25, "Male");
            UserService.addUser(2, "emma@example.com", "hash456", "Emma", 22, "Female");
            UserService.addUser(3, "mike@example.com", "hash789", "Mike", 28, "Male");

            // Add exercise types
            ExerciseTypeService.addType(1, "Cardio");
            ExerciseTypeService.addType(2, "Strength");

            // Add exercises
            ExerciseService.addExercise(1, 1, "Running");
            ExerciseService.addExercise(2, 2, "Bench Press");
            ExerciseService.addExercise(3, 2, "Deadlift");
            ExerciseService.addExercise(4, 2, "Squat");
            ExerciseService.addExercise(5, 1, "Cycling");

            // Log workouts
            WorkoutService.logWorkout(1, "2025-07-28");
            WorkoutService.addExerciseToWorkout(1, 2, 10, 3); // Bench Press

            WorkoutService.logWorkout(2,  "2025-07-29");
            WorkoutService.addExerciseToWorkout(2, 3, 8, 4); // Deadlift

            WorkoutService.logWorkout(3,  "2025-07-28");
            WorkoutService.addExerciseToWorkout(3, 1, 0, 30); // Running

            // Add weight entries
            WeightService.addWeightEntry(1, 1, 72.5, "2025-07-28");
            WeightService.addWeightEntry(2, 2, 59.2, "2025-07-28");

            // Query frequent exercises
            FrequentQueries.mostFrequentExercise(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean tableExists(DatabaseMetaData meta, String tableName) throws Exception {
        ResultSet rs = meta.getTables(null, null, tableName, new String[]{"TABLE"});
        return rs.next();
    }
}
