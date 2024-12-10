package Repository;
import Model.Monitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MonitorRepository {
    private Connection connection;

    public MonitorRepository(Connection connection) {
        this.connection = connection;
    }

    //Metoda pentru a adăuga un monitor
    public void createMonitor(Monitor monitor) {
        String sql = "INSERT INTO monitoare (producator, model, pret, dimensiune_diagonala, rata_refresh, creation_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, monitor.getProducator());
            stmt.setString(2, monitor.getModel());
            stmt.setDouble(3, monitor.getPret());
            stmt.setInt(4, monitor.getDimensiuneDiagonala());
            stmt.setInt(5, monitor.getRataRefresh());
            stmt.setDate(6, java.sql.Date.valueOf(monitor.getCreationDate()));
            stmt.executeUpdate();
            System.out.println("Monitor adăugat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea monitorului: " + e.getMessage());
        }
    }

    //Metoda pentru a citi detaliile unui monitor
    public Monitor readMonitor(int id) {
        String sql = "SELECT * FROM monitoare WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String producator = rs.getString("producator");
                String model = rs.getString("model");
                double pret = rs.getDouble("pret");
                int dimensiuneDiagonala = rs.getInt("dimensiune_diagonala");
                int rataRefresh = rs.getInt("rata_refresh");
                LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
                return new Monitor(producator, model, pret, dimensiuneDiagonala, rataRefresh, creationDate);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea monitorului: " + e.getMessage());
        }
        return null; // Returnează null dacă monitorul nu a fost găsit
    }

    //Metoda pentru a actualiza detaliile unui monitor
    public void updateMonitor(int id, Monitor monitor) {
        String sql = "UPDATE monitoare SET producator = ?, model = ?, pret = ?, dimensiune_diagonala = ?, rata_refresh = ?, creation_date = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, monitor.getProducator());
            stmt.setString(2, monitor.getModel());
            stmt.setDouble(3, monitor.getPret());
            stmt.setInt(4, monitor.getDimensiuneDiagonala());
            stmt.setInt(5, monitor.getRataRefresh());
            stmt.setDate(6, java.sql.Date.valueOf(monitor.getCreationDate()));
            stmt.setInt(7, id);
            stmt.executeUpdate();
            System.out.println("Monitor actualizat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea monitorului: " + e.getMessage());
        }
    }

    //Metoda pentru a șterge un monitor
    public void deleteMonitor(int id) {
        String sql = "DELETE FROM monitoare WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Monitor șters cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea monitorului: " + e.getMessage());
        }
    }
}