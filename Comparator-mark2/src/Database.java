import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://db4free.net:3306/proiectip12345";
    private static final String USER = "amrus12345";
    private static final String PASSWORD = "databaseacces";
    private static Connection connection = null;
    private Database() { }
    public static Connection getConnection() {
        if (connection == null) {
            databaseConnect();
        }
        return connection;
    }
    public static Connection databaseConnect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception exc) {
            System.out.println("Connection Failed!");
            exc.printStackTrace();

        } if(connection!=null){
            System.out.println("Conexiunea a avut succes");
            return connection;
        }else {
            System.out.println("Conexiunea NU a avut succes");
            return null;
        }

    }

    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
