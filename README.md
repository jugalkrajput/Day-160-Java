📘 Day 16 – JDBC (Java Database Connectivity)
==============================================

✅ What I learned today

1. JDBC Steps
   -----------

Load Driver → 2. Establish Connection → 3. Create Statement → 4. Execute Query → 5. Process ResultSet → 6. Close

2. Connection Code
   ----------------

// Code

String url = "jdbc:mysql://localhost:3306/db_name";

Connection conn = DriverManager.getConnection(url, "root", "password");


3. PreparedStatement
   -----------------

-> Prevents SQL Injection

-> Efficient for repeated queries

-> Uses ? placeholders

// Code

String sql = "INSERT INTO students (name, marks) VALUES (?, ?)";

PreparedStatement pstmt = conn.prepareStatement(sql);

pstmt.setString(1, "Raj");

pstmt.setDouble(2, 85.5);

pstmt.executeUpdate();


4. CRUD Operations
   ---------------

Operation	|	SQL		|	JDBC Method
----------------|-----------------------|----------------------------------
INSERT		|	INSERT INTO ...	|	executeUpdate()
SELECT		|	SELECT ...	|	executeQuery() → ResultSet
UPDATE		|	UPDATE ...	|	executeUpdate()
DELETE		|	DELETE ...	|	executeUpdate()


5. ResultSet Methods
   -------------------

rs.next() → move to next row

rs.getInt("col") → get int

rs.getString("col") → get string

rs.getDouble("col") → get double

6. Try-with-resources (auto close)
   --------------------------------

try (Connection conn = DriverManager.getConnection(url, user, pass);

     PreparedStatement pstmt = conn.prepareStatement(sql)) {

    // code

} // auto-closes
