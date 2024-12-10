package Repository;

import Model.Telefon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TelefonRepository {
    private Connection connection;

    public TelefonRepository(Connection connection) {
        this.connection = connection;
    }

    // 4.2 Metoda pentru a adăuga un telefon
    public void createTelefon(Telefon telefon) {
        String sql = "INSERT INTO telefoane (producator, model, pret, dimensiune_diagonala, memorie_interna, memorie_ram, sistem_operare, culoare, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, telefon.getProducator());
            stmt.setString(2, telefon.getModel());
            stmt.setDouble(3, telefon.getPret());
            stmt.setInt(4, telefon.getDimensiuneDiagonala());
            stmt.setInt(5, telefon.getMemorieInterna());
            stmt.setInt(6, telefon.getMemorieRAM());
            stmt.setString(7, telefon.getSistemOperare());
            stmt.setString(8, telefon.getCuloare());
            stmt.setDate(9, java.sql.Date.valueOf(telefon.getCreationDate()));
            stmt.executeUpdate();
            System.out.println("Telefon adăugat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea telefonului: " + e.getMessage());
        }
    }

    // 4.3 Metoda pentru a citi detaliile unui telefon
    public Telefon readTelefon(int id) {
        String sql = "SELECT * FROM telefoane WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String producator = rs.getString("producator");
                String model = rs.getString("model");
                double pret = rs.getDouble("pret");
                int dimensiuneDiagonala = rs.getInt("dimensiune_diagonala");
                int memorieInterna = rs.getInt("memorie_interna");
                int memorieRAM = rs.getInt("memorie_ram");
                String sistemOperare = rs.getString("sistem_operare");
                String culoare = rs.getString("culoare");
                LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
                return new Telefon(producator, model, pret, dimensiuneDiagonala, memorieInterna, memorieRAM, sistemOperare, culoare, creationDate);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea telefonului: " + e.getMessage());
        }
        return null; // Returnează null dacă telefonul nu a fost găsit
    }

    // 4.4 Metoda pentru a actualiza detaliile unui telefon
    public void updateTelefon(int id, Telefon telefon) {
        String sql = "UPDATE telefoane SET producator = ?, model = ?, pret = ?, dimensiune_diagonala = ?, memorie_interna = ?, memorie_ram = ?, sistem_operare = ?, culoare = ?, creation_date = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, telefon.getProducator());
            stmt.setString(2, telefon.getModel());
            stmt.setDouble(3, telefon.getPret());
            stmt.setInt(4, telefon.getDimensiuneDiagonala());
            stmt.setInt(5, telefon.getMemorieInterna());
            stmt.setInt(6, telefon.getMemorieRAM());
            stmt.setString(7, telefon.getSistemOperare());
            stmt.setString(8, telefon.getCuloare());
            stmt.setDate(9, java.sql.Date.valueOf(telefon.getCreationDate()));
            stmt.setInt(10, id);
            stmt.executeUpdate();
            System.out.println("Telefon actualizat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea telefonului: " + e.getMessage());
        }
    }

    // 4.5 Metoda pentru a șterge un telefon
    public void deleteTelefon(int id) {
        String sql = "DELETE FROM telefoane WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Telefon șters cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea telefonului: " + e.getMessage());
        }
    }
}