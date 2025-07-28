import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GymDatabaseInitializer {
    public static void createTables(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            // Drop existing tables in correct order (to avoid FK issues)
            stmt.execute("DROP TABLE IF EXISTS workout_exercise");
            stmt.execute("DROP TABLE IF EXISTS workout");
            stmt.execute("DROP TABLE IF EXISTS weight_entry");
            stmt.execute("DROP TABLE IF EXISTS exercise");
            stmt.execute("DROP TABLE IF EXISTS exercise_type");
            stmt.execute("DROP TABLE IF EXISTS user");

            // Create user table
            stmt.execute("""
    CREATE TABLE user (
        user_id INT PRIMARY KEY,
        email VARCHAR(100),
        password_hash VARCHAR(100),
        name VARCHAR(100),
        age INT,
        gender VARCHAR(10),
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )
""");

            // Create exercise_type table
            stmt.execute("""
                CREATE TABLE exercise_type (
                    type_id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(50) NOT NULL
                )
            """);

            // Create exercise table
            stmt.execute("""
                CREATE TABLE exercise (
                    exercise_id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    type_id INT,
                    FOREIGN KEY (type_id) REFERENCES exercise_type(type_id)
                )
            """);

            // Create workout table
            stmt.executeUpdate("""
    CREATE TABLE IF NOT EXISTS workout (
        workout_id INT PRIMARY KEY AUTO_INCREMENT,
        user_id INT,
        date DATE,
        FOREIGN KEY (user_id) REFERENCES user(user_id)
    )
""");
            // Create workout_exercise table (join table)
            stmt.execute("""
                CREATE TABLE workout_exercise (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    workout_id INT,
                    exercise_id INT,
                    sets INT,
                    reps INT,
                    FOREIGN KEY (workout_id) REFERENCES workout(workout_id),
                    FOREIGN KEY (exercise_id) REFERENCES exercise(exercise_id)
                )
            """);

            // Create weight_entry table
            stmt.execute("""
                CREATE TABLE weight_entry (
                    entry_id INT AUTO_INCREMENT PRIMARY KEY,
                    user_id INT,
                    entry_date DATE,
                    weight DECIMAL(5,2),
                    FOREIGN KEY (user_id) REFERENCES user(user_id)
                )
            """);

            System.out.println("✅ Tables created successfully.");
        } catch (SQLException e) {
            System.err.println("❌ Error creating tables: " + e.getMessage());
            e.printStackTrace();
        }
    }
}