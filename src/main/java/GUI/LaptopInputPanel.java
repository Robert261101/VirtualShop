package GUI;

import Database.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.random.RandomGenerator;

public class LaptopInputPanel {
    private JPanel mainPanel;
    private JButton btnAdauga;
    private JButton btnSterge;
    private JButton btnModifica;
    private JButton btnAfiseaza;
    private JButton btnCauta;
    private JButton btnCancel;
    private JTextField txtFldID;
    private JTable laptopTable;
    private JLabel labelID;
    private JLabel labelProducator;
    private JLabel labelModel;
    private JLabel labelPret;
    private JLabel labelTipProcesor;
    private JLabel labelMemorieRAM;
    private JLabel labelDimensiuneDiagonala;
    private JLabel labelSistemOperare;
    private JLabel labelTipStocare;
    private JTextField txtFldProducator;
    private JTextField txtFldModel;
    private JTextField txtFldPret;
    private JTextField txtFldTipProcesor;
    private JTextField txtFldMemorieRAM;
    private JTextField txtFldDimensiuneDiagonala;
    private JTextField txtFldSistemOperare;
    private JTextField txtFldTipStocare;
    private JScrollPane scrollPaneLaptop;

    public LaptopInputPanel() {

        mainPanel = new JPanel(new GridBagLayout()); // Layout principal
        GridBagConstraints gbc = new GridBagConstraints();

        // Setează proprietăți comune
        gbc.insets = new Insets(5, 5, 5, 5); // Spațiere (margini între componente)
        gbc.fill = GridBagConstraints.HORIZONTAL; // Componentele se extind pe lățime

        // Creează JTable și adaugă la JScrollPane
        laptopTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(laptopTable);


        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(btnAdauga, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(btnSterge, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(btnModifica, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        mainPanel.add(btnAfiseaza, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(labelID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(labelProducator, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(labelModel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(labelPret, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(labelTipProcesor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(labelMemorieRAM, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(labelDimensiuneDiagonala, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(labelSistemOperare, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        mainPanel.add(labelTipStocare, gbc);


        gbc.gridx = 2;
        gbc.gridy = 1;
        mainPanel.add(txtFldID, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        mainPanel.add(txtFldProducator, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        mainPanel.add(txtFldModel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        mainPanel.add(txtFldPret, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        mainPanel.add(txtFldTipProcesor, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        mainPanel.add(txtFldMemorieRAM, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        mainPanel.add(txtFldDimensiuneDiagonala, gbc);

        gbc.gridx = 2;
        gbc.gridy = 8;
        mainPanel.add(txtFldSistemOperare, gbc);

        gbc.gridx = 2;
        gbc.gridy = 9;
        mainPanel.add(txtFldTipStocare, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        mainPanel.add(btnCancel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        mainPanel.add(btnCauta, gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridheight = 11;
        mainPanel.add(scrollPane, gbc);

        // Încarcă datele din baza de date
        populateTableWithDatabaseData();

        btnAdauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String producator =txtFldProducator.getText();
                String model=txtFldModel.getText();
                String pret=txtFldPret.getText();
                String tipProcesor=txtFldTipProcesor.getText();
                String memorieRAM=txtFldMemorieRAM.getText();
                String dimensiuneDiagonala=txtFldDimensiuneDiagonala.getText();
                String sistemOperare=txtFldSistemOperare.getText();
                String tipStocare=txtFldTipStocare.getText();

                if (producator.isEmpty() || model.isEmpty() || pret.isEmpty() || tipProcesor.isEmpty() || memorieRAM.isEmpty() || dimensiuneDiagonala.isEmpty() || sistemOperare.isEmpty() || tipStocare.isEmpty()){
                    JOptionPane.showMessageDialog(mainPanel,
                            "Toate campurile trebuie completate",
                            "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DatabaseConnection dbConnection= new DatabaseConnection();
                dbConnection.openConnection();

                try (Connection connection = dbConnection.getConnection();
                     Statement statement = connection.createStatement()) {

                    //Adauga dispozitiul in baza de date
                    String query = String.format("INSERT INTO laptopuri(producator, model, pret, tip_procesor, memorie_ram, dimensiune_diagonala, sistem_operare, tip_stocare)"+
                            "VALUES ('%s','%s','%s','%s','%s','%s','%s','%s',)", producator,model,Double.parseDouble(pret),tipProcesor,memorieRAM,Integer.parseInt(dimensiuneDiagonala),sistemOperare,tipStocare);

                    statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(mainPanel, "Dispozitivul a fost adăugat cu succes!");
                    populateTableWithDatabaseData();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel,
                            "Eroare la adăugarea dispozitivului: " + ex.getMessage(),
                            "Eroare", JOptionPane.ERROR_MESSAGE);
                } finally {
                    dbConnection.closeConnection();
                }
                clearTextFields();
            }
        });
        btnSterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtFldID.getText();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Introduceți un ID pentru a șterge!", "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DatabaseConnection dbConnection = new DatabaseConnection();
                dbConnection.openConnection();

                try (Connection connection = dbConnection.getConnection();
                     Statement statement = connection.createStatement()) {

                    //Sterge dispozitivul
                    statement.executeUpdate("DELETE FROM laptopuri WHERE id = " + Integer.parseInt(id));

                    //Actualizeaza ID-urile ramase
                    statement.execute("SET @count=0");
                    statement.execute("UPDATE laptopuri SET id=(@count := @count +1)");
                    statement.execute("ALTER TABLE laptopuri AUTO_INCREMENT = 1");

                    JOptionPane.showMessageDialog(mainPanel,
                            "Dispozitivul a fost șters cu succes!");
                    populateTableWithDatabaseData();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel, "Eroare la ștergerea dispozitivului: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
                } finally {
                    dbConnection.closeConnection();
                }
                clearTextFields();
            }
        });
        btnModifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtFldID.getText();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel,
                            "Introduceți un ID pentru a modifica!",
                            "Eroare", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DatabaseConnection dbConnection = new DatabaseConnection();
                dbConnection.openConnection();

                try(Connection connection= dbConnection.getConnection();
                    Statement statement=connection.createStatement()){

                    //Construieste query-ul de actualizare
                    StringBuilder query=new StringBuilder("UPDATE laptopuri SET");
                    boolean hasChanges=false;

                    if(!txtFldProducator.getText().isEmpty()){
                        query.append("producator =").append(txtFldProducator.getText()).append(",");
                        hasChanges=true;
                    }

                    if(!txtFldModel.getText().isEmpty()){
                        query.append("model = ").append(txtFldModel.getText()).append("',");
                        hasChanges=true;
                    }

                    if (!txtFldPret.getText().isEmpty()) {
                        query.append("pret = ").append(Double.parseDouble(txtFldPret.getText())).append("', ");
                        hasChanges = true;
                    }

                    if (!txtFldTipProcesor.getText().isEmpty()) {
                        query.append("tip_procesor = '").append(txtFldTipProcesor.getText()).append("', ");
                        hasChanges = true;
                    }

                    if(!txtFldMemorieRAM.getText().isEmpty()){
                        query.append("memorie_ram = ").append(txtFldMemorieRAM.getText()).append("',");
                        hasChanges=true;
                    }

                    if(!txtFldDimensiuneDiagonala.getText().isEmpty()){
                        query.append("dimensiune_diagonala = ").append(Integer.parseInt(txtFldDimensiuneDiagonala.getText())).append("',");
                        hasChanges=true;
                    }

                    if (!txtFldSistemOperare.getText().isEmpty()) {
                        query.append("sistem_operare = '").append(txtFldSistemOperare.getText()).append("', ");
                        hasChanges = true;
                    }

                    if (!txtFldTipStocare.getText().isEmpty()) {
                        query.append("tip_stocare = '").append(txtFldTipStocare.getText()).append("', ");
                        hasChanges = true;
                    }

                    if(!hasChanges){
                        JOptionPane.showMessageDialog(mainPanel,
                                "Nu a fost furnizată nicio informație pentru modificare!",
                                "Eroare",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    query.setLength(query.length() - 2); // Elimină ultima virgulă
                    query.append(" WHERE id = ").append(Integer.parseInt(id));

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel, "Eroare la modificarea dispozitivului: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
                } finally {
                    dbConnection.closeConnection();
                }
                clearTextFields();
            }
        });
        btnAfiseaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Încarcă datele din baza de date
                populateTableWithDatabaseData();
            }
        });
        btnCauta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder query = new StringBuilder("SELECT * FROM laptopuri WHERE 1=1");

                if(!txtFldProducator.getText().isEmpty()){
                    query.append(" AND producator = '").append(txtFldProducator.getText()).append("'");
                }
                if(!txtFldModel.getText().isEmpty()){
                    query.append(" AND model = '").append(txtFldModel.getText()).append("'");
                }
                if (!txtFldPret.getText().isEmpty()) {
                    query.append(" AND pret = '").append(Double.parseDouble(txtFldPret.getText())).append("'");
                }
                if (!txtFldTipProcesor.getText().isEmpty()) {
                    query.append(" AND tip_procesor = '").append(txtFldTipProcesor.getText()).append("'");
                }
                if (!txtFldMemorieRAM.getText().isEmpty()) {
                    query.append(" AND memorie_ram = '").append(txtFldMemorieRAM.getText()).append("'");
                }
                if(!txtFldDimensiuneDiagonala.getText().isEmpty()){
                    query.append(" AND dimensiune_diagonala = '").append(Integer.parseInt(txtFldDimensiuneDiagonala.getText())).append("'");
                }
                if (!txtFldSistemOperare.getText().isEmpty()) {
                    query.append(" AND sistem_operare = '").append(txtFldSistemOperare.getText()).append("'");
                }
                if (!txtFldTipStocare.getText().isEmpty()) {
                    query.append(" AND tip_stocare = '").append(txtFldTipStocare.getText()).append("'");
                }

                DatabaseConnection dbConnection = new DatabaseConnection();
                dbConnection.openConnection();

                try (Connection connection = dbConnection.getConnection();
                     Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query.toString())) {

                    // Populează tabelul cu rezultatele căutării
                    DefaultTableModel tableModel = (DefaultTableModel) laptopTable.getModel();
                    tableModel.setRowCount(0);

                    while (resultSet.next()) {
                        Object[] rowData = {
                                resultSet.getInt("id"),
                                resultSet.getString("producator"),
                                resultSet.getString("model"),
                                resultSet.getDouble("pret"),
                                resultSet.getString("tip_procesor"),
                                resultSet.getString("memorie_ram"),
                                resultSet.getInt("dimensiune_diagonala"),
                                resultSet.getString("sistem_operare"),
                                resultSet.getString("tip_stocare")
                        };
                        tableModel.addRow(rowData);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel, "Eroare la căutare: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
                } finally {
                    dbConnection.closeConnection();
                }
                clearTextFields();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Închide fereastra curentă
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                frame.dispose();
            }
        });
    }
    private void clearTextFields() {
        txtFldID.setText("");
        txtFldProducator.setText("");
        txtFldPret.setText("");
        txtFldModel.setText("");
        txtFldTipProcesor.setText("");
        txtFldMemorieRAM.setText("");
        txtFldDimensiuneDiagonala.setText("");
        txtFldSistemOperare.setText("");
        txtFldTipStocare.setText("");
    }

    private void populateTableWithDatabaseData() {
        // Definește coloanele tabelului
        String[] columnNames = {"ID", "Producator", "Model", "Pret", "Tip Procesor", "Memorie RAM", "Dimensiune Diagonala", "Sistem Operare", "Tip Stocare"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        DatabaseConnection dbConnection = new DatabaseConnection(); // Creează instanța
        dbConnection.openConnection(); // Deschide conexiunea

        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM laptopuri")) {

            // Adaugă datele din ResultSet în modelul tabelului
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String producator= resultSet.getString("producator");
                String model = resultSet.getString("model");
                double pret = resultSet.getDouble("pret");
                String tipProcesor = resultSet.getString("tip_procesor");
                String memorieRAM= resultSet.getString("memorie_ram");
                int dimensiuneDiagonala= resultSet.getInt("dimensiune_diagonala");
                String sistemOperare= resultSet.getString("sistem_operare");
                String tipStocare=resultSet.getString("tip_stocare");


                Object[] rowData = {id, producator, model, pret, tipProcesor, memorieRAM, dimensiuneDiagonala, sistemOperare, tipStocare};
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainPanel, "Eroare la încărcarea datelor din baza de date: " + e.getMessage(),
                    "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            dbConnection.closeConnection(); // Închide conexiunea când nu mai e necesară
        }

        // Setează modelul pentru tabel
        laptopTable.setModel(tableModel);
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
