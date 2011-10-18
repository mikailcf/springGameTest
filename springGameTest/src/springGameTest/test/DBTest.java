package springGameTest.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Connection conn = null;

        try {
            String userName = "PROCDB";
            String password = "PROCDB";
            String url = "jdbc:mysql://localhost:3306/gameDB";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");

            Statement s = conn.createStatement();
            s.executeQuery("SELECT ID_SKILL, ID_PARENT_SKILL, FL_DIFFICULTY, ST_NAME FROM SKILL");
            ResultSet rs = s.getResultSet();
            int count = 0;
            while (rs.next())
            {
                int idVal = rs.getInt("ID_SKILL");
                int idParentVal = rs.getInt("ID_PARENT_SKILL");
                double difficultyVal = rs.getDouble("FL_DIFFICULTY");
                String nameVal = rs.getString("ST_NAME");
                System.out.println(
                        "id = " + idVal
                        + ", parent id = " + idParentVal
                        + ", difficulty = " + difficultyVal
                        + ", name = " + nameVal);
                ++count;
            }
            rs.close();
            s.close();
            System.out.println (count + " rows were retrieved");
        }
        catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.out.println(e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
	}

}
