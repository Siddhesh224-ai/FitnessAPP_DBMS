import java.sql.Connection;
import java.sql.PreparedStatement;

public class WeightService {
    public static void addWeightEntry(long entryId, long userId, double weight, String date) {
        String sql = "INSERT INTO weight_entry (entry_id, user_id, weight, entry_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, entryId);
            stmt.setLong(2, userId);
            stmt.setDouble(3, weight);
            stmt.setString(4, date);

            stmt.executeUpdate();
            System.out.println("Weight entry recorded.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
