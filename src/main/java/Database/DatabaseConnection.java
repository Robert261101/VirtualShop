package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/magazin_saw"; // URL-ul bazei de date
    private static String username = "root"; // Numele utilizatorului
    private static String password = "root"; // Parola (lasă goală dacă nu ai parolă)

    // Constructor
    public DatabaseConnection() {
        this.connection = null;
    }

    // Metoda pentru a deschide conexiunea
    public void openConnection() {
        try {
            // Încarcă driver-ul MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Deschide conexiunea
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexiune reușită la baza de date!");
        } catch (SQLException e) {
            System.out.println("Eroare la conectarea la baza de date: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver-ul MySQL nu a fost găsit: " + e.getMessage());
        }
    }

    // Metoda pentru a închide conexiunea
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexiunea a fost închisă.");
            } catch (SQLException e) {
                System.out.println("Eroare la închiderea conexiunii: " + e.getMessage());
            }
        }
    }

    // Metoda pentru a obține conexiunea (pentru a o folosi în alte clase)
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}