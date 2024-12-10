package Repository;

import Model.Televizor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TelevizorRepository {
    private Connection connection;

    public TelevizorRepository(Connection connection) {
        this.connection = connection;
    }

    //Metoda pentru a adăuga un televizor
    public void createTelevizor(Televizor televizor) {
        String sql = "INSERT INTO televizoare (producator, model, pret, dimensiune_diagonala, tehnologie_display, claritate_imagine, clasa_energetica) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, televizor.getProducator());
            stmt.setString(2, televizor.getModel());
            stmt.setDouble(3, televizor.getPret());
            stmt.setInt(4, televizor.getDimensiuneDiagonala());
            stmt.setString(5, televizor.getTehnologieDisplay());
            stmt.setString(6, televizor.getClaritateImagine());
            stmt.setString(7, televizor.getClasaEnergetica());
            stmt.executeUpdate();
            System.out.println("Televizor adăugat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea televizorului: " + e.getMessage());
        }
    }

    //Metoda pentru a citi detaliile unui televizor
    public Televizor readTelevizor(int id) {
        String sql = "SELECT * FROM televizoare WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String producator = rs.getString("producator");
                String model = rs.getString("model");
                double pret = rs.getDouble("pret");
                int dimensiuneDiagonala = rs.getInt("dimensiune_diagonala");
                String tehnologieDisplay = rs.getString("tehnologie_display");
                String claritateImagine = rs.getString("claritate_imagine");
                String clasaEnergetica = rs.getString("clasa_energetica");
                LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
                return new Televizor(producator, model, pret, dimensiuneDiagonala, tehnologieDisplay, claritateImagine, clasaEnergetica, creationDate);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea televizorului: " + e.getMessage());
        }
        return null; // Returnează null dacă televizorul nu a fost găsit
    }

    //Metoda pentru a actualiza detaliile unui televizor
    public void updateTelevizor(int id, Televizor televizor) {
        String sql = "UPDATE televizoare SET producator = ?, model = ?, pret = ?, dimensiune_diagonala = ?, tehnologie_display = ?, claritate_imagine = ?, clasa_energetica = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, televizor.getProducator());
            stmt.setString(2, televizor.getModel());
            stmt.setDouble(3, televizor.getPret());
            stmt.setInt(4, televizor.getDimensiuneDiagonala());
            stmt.setString(5, televizor.getTehnologieDisplay());
            stmt.setString(6, televizor.getClaritateImagine());
            stmt.setString(7, televizor.getClasaEnergetica());
            stmt.setInt(8, id);
            stmt.executeUpdate();
            System.out.println("Televizor actualizat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea televizorului: " + e.getMessage());
        }
    }

    //Metoda pentru a șterge un televizor
    public void deleteTelevizor(int id) {
        String sql = "DELETE FROM televizoare WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Televizor șters cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea televizorului: " + e.getMessage());
        }
    }
}