
package Repository;

import Model.Calculator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CalculatorRepository {
    private Connection connection;

    public CalculatorRepository(Connection connection) {
        this.connection = connection;
    }

    //Metoda pentru a adăuga un calculator
    public void createCalculator(Calculator calculator) {
        String sql = "INSERT INTO calculatoare (model, pret, tip_procesor, placa_video, memorie_ram, sistem_operare, tip_stocare, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, calculator.getModel());
            stmt.setDouble(2, calculator.getPret());
            stmt.setString(3, calculator.getTipProcesor());
            stmt.setString(4, calculator.getPlacaVideo());
            stmt.setString(5, calculator.getMemorieRAM());
            stmt.setString(6, calculator.getSistemOperare());
            stmt.setString(7, calculator.getTipStocare());
            stmt.setDate(8, java.sql.Date.valueOf(calculator.getCreationDate()));
            stmt.executeUpdate();
            System.out.println("Calculator adăugat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea calculatorului: " + e.getMessage());
        }
    }

    //Metoda pentru a citi detaliile unui calculator
    public Calculator readCalculator(int id) {
        String sql = "SELECT * FROM calculatoare WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String model = rs.getString("model");
                double pret = rs.getDouble("pret");
                String tipProcesor = rs.getString("tip_procesor");
                String placaVideo = rs.getString("placa_video");
                String memorieRAM = rs.getString("memorie_ram");
                String sistemOperare = rs.getString("sistem_operare");
                String tipStocare = rs.getString("tip_stocare");
                LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
                return new Calculator(model, pret, tipProcesor, placaVideo, memorieRAM, sistemOperare, tipStocare, creationDate);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea calculatorului: " + e.getMessage());
        }
        return null; // Returnează null dacă calculatorul nu a fost găsit
    }

    //Metoda pentru a actualiza detaliile unui calculator
    public void updateCalculator(int id, Calculator calculator) {
        String sql = "UPDATE calculatoare SET model = ?, pret = ?, tip_procesor = ?, placa_video = ?, memorie_ram = ?, sistem_operare = ?, tip_stocare = ?, creation_date = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, calculator.getModel());
            stmt.setDouble(2, calculator.getPret());
            stmt.setString(3, calculator.getTipProcesor());
            stmt.setString(4, calculator.getPlacaVideo());
            stmt.setString(5, calculator.getMemorieRAM());
            stmt.setString(6, calculator.getSistemOperare());
            stmt.setString(7, calculator.getTipStocare());
            stmt.setDate(8, java.sql.Date.valueOf(calculator.getCreationDate()));
            stmt.setInt(9, id);
            stmt.executeUpdate();
            System.out.println("Calculator actualizat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea calculatorului: " + e.getMessage());
        }
    }

    //Metoda pentru a șterge un calculator
    public void deleteCalculator(int id) {
        String sql = "DELETE FROM calculatoare WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Calculator șters cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea calculatorului: " + e.getMessage());
        }
    }
}