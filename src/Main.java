//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){


        UserService.addUser(1, "sid@example.com", "pass123", "Siddhesh", 21, "MALE");

        ExerciseService.addExercise(1, 1, "Pushup");

        WorkoutService.logWorkout(1001, 1, "2025-07-27");
        WorkoutService.addExerciseToWorkout(1001, 1, 10, 3);

        WeightService.addWeightEntry(1, 1, 70.5, "2025-07-27");

        FrequentQueries.mostFrequentExercise(1);
    }
}
