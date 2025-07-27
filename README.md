🏋️ JDBC Assignment — Gym Management System

This project demonstrates a comprehensive Gym Management Database System using Java (JDBC) and MySQL. It is designed to simulate real-world operations of a fitness center by managing members, workouts, exercises, weights, and more — all via command-line interface.

📌 Overview

- The entry point is the Main class, which connects to the MySQL database and invokes the table creation and data interaction modules.
- The database schema is set up by GymDatabaseInitializer, which drops existing tables (if any) and recreates them in the proper dependency order.
- Data entry into tables is handled by GymDataInserter, with functions for adding users, exercises, workouts, weight entries, and more.
- Common queries and analytics are handled in FrequentQueries, such as:
  - Weight trends
  - Most frequent exercises
  - Average workout frequency
  - Member progress tracking

🧱 Main Components

🔹 Main
- Connects to the MySQL database using JDBC.
- Calls GymDatabaseInitializer.createTables(connection) to initialize the schema.

🔹 GymDatabaseInitializer
- Method: createTables(Connection conn)
- Drops and recreates all tables:
  - Users, Workouts, Exercises, User_Workouts, Weight_Log, etc.

🔹 GymDataInserter
- Provides static methods to insert data:
  - insertUser(...)
  - insertWorkout(...)
  - insertExercise(...)
  - insertWeightEntry(...)

🔹 FrequentQueries
- Analytical and business intelligence queries such as:
  - Most active user
  - Most used exercise
  - Weight progress chart
  - User consistency
  - Goal achievement tracking

▶️ Usage

🖥️ Requirements
- Java 17 or higher
- MySQL Server running at localhost:3306
- Database: FitnessAPP (auto-created)

⚙️ Steps to Run

1. Update Credentials  
   In DBConnection.java, set:
   private static final String USER = "your_mysql_username";
   private static final String PASSWORD = "your_mysql_password";

2. Build and Run
   - Using IntelliJ:
     - Build > Build Artifacts > JAR > From Modules with Dependencies
     - Set Main as entry class
     - Click Build
     - Run:
       java -jar out/artifacts/VivaDBMS_jar/VivaDBMS.jar

3. Populate Data
   - Use GymDataInserter methods to add users, exercises, etc.

4. Run Analytics
   - Call methods from FrequentQueries to test various DBMS queries.

✅ Teacher Verification Steps

1. Clone the repo:
   git clone https://github.com/Siddhesh224-ai/FitnessAPP_DBMS.git
   cd FitnessAPP_DBMS

2. Ensure MySQL is running locally and schema name is FitnessAPP.

3. Run the jar:
   java -jar out/artifacts/VivaDBMS_jar/VivaDBMS.jar

4. Review terminal output and optionally connect to MySQL via Workbench to inspect data.

📁 Example Tables

- Users (user_id, name, age, gender)
- Exercises (exercise_id, name, type, target_muscle)
- Workouts (workout_id, user_id, date)
- Workout_Exercises (id, workout_id, exercise_id, sets, reps)
- Weight_Log (log_id, user_id, weight, date)

🧠 Submitted By

Name: Siddhesh Mutha  
Course: Database Management Systems  
Submission: Viva Practical Project  
GitHub Repo: https://github.com/Siddhesh224-ai/FitnessAPP_DBMS

 Contact

  private static final String PASSWORD = "password";
