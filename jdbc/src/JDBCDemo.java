import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees_database";
        // establish connection to db
        // Note: remember to add connector jar to build path
        try (Connection conn = DriverManager.getConnection(url, "root", System.getenv("MYSQL_PASSWORD"))) {
            // create a statement object
            Statement statement = conn.createStatement();

            ResultSet res = statement.executeQuery("SELECT * from employees_tbl");

            // display result
            while (res.next()) {
                System.out.println(res.getString("name"));
            }

            // sanitize input to avoid sql injection
            PreparedStatement ps = conn.prepareStatement("INSERT INTO employees_tbl (id, name, dept, salary) "
                    + "VALUES (?, ?, ?, ?)");
            ps.setInt(1, 1);
            ps.setString(2, "Bruce");
            ps.setString(3, "Technology");
            ps.setInt(4, 99999999);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
