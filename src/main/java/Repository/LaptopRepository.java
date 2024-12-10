package Repository;

import Model.Laptop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LaptopRepository {
    private Connection connection;

    public LaptopRepository(Connection connection) {
        this.connection = connection;
    }

    //Metoda pentru a adăuga un laptop
    public void createLaptop(Laptop laptop) {
        String sql = "INSERT INTO laptopuri (producator, model, pret, tip_procesor, memorie_ram, dimensiune_diagonala, sistem_operare, tip_stocare, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, laptop.getProducator());
            stmt.setString(2, laptop.getModel());
            stmt.setDouble(3, laptop.getPret());
            stmt.setString(4, laptop.getTipProcesor());
            stmt.setString(5, laptop.getMemorieRAM());
            stmt.setInt(6, laptop.getDimensiuneDiagonala());
            stmt.setString(7, laptop.getSistemOperare());
            stmt.setString(8, laptop.getTipStocare());
            stmt.setDate(9, java.sql.Date.valueOf(laptop.getCreationDate()));
            stmt.executeUpdate();
            System.out.println("Laptop adăugat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea laptopului: " + e.getMessage());
        }
    }

    //Metoda pentru a citi detaliile unui laptop
    public Laptop readLaptop(int id) {
        String sql = "SELECT * FROM laptopuri WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String producator = rs.getString("producator");
                String model = rs.getString("model");
                double pret = rs.getDouble("pret");
                String tipProcesor = rs.getString("tip_procesor");
                String memorieRAM = rs.getString("memorie_ram");
                int dimensiuneDiagonala = rs.getInt("dimensiune_diagonala");
                String sistemOperare = rs.getString("sistem_operare");
                String tipStocare = rs.getString("tip_stocare");
                LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
                return new Laptop(producator, model, pret, tipProcesor, memorieRAM, dimensiuneDiagonala, sistemOperare, tipStocare, creationDate);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea laptopului: " + e.getMessage());
        }
        return null; // Returnează null dacă laptopul nu a fost găsit
    }

    //Metoda pentru a actualiza detaliile unui laptop
    public void updateLaptop(int id, Laptop laptop) {
        String sql = "UPDATE laptopuri SET producator = ?, model = ?, pret = ?, tip_procesor = ?, memorie_ram = ?, dimensiune_diagonala = ?, sistem_operare = ?, tip_stocare = ?, creation_date = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString( 1, laptop.getProducator());
            stmt.setString(2, laptop.getModel());
            stmt.setDouble(3, laptop.getPret());
            stmt.setString(4, laptop.getTipProcesor());
            stmt.setString(5, laptop.getMemorieRAM());
            stmt.setInt(6, laptop.getDimensiuneDiagonala());
            stmt.setString(7, laptop.getSistemOperare());
            stmt.setString(8, laptop.getTipStocare());
            stmt.setDate(9, java.sql.Date.valueOf(laptop.getCreationDate()));
            stmt.setInt(10, id);
            stmt.executeUpdate();
            System.out.println("Laptop actualizat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea laptopului: " + e.getMessage());
        }
    }

    //Metoda pentru a șterge un laptop
    public void deleteLaptop(int id) {
        String sql = "DELETE FROM laptopuri WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Laptop șters cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea laptopului: " + e.getMessage());
        }
    }
}