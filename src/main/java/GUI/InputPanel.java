package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Calculator;
import Repository.CalculatorRepository;
import Model.Laptop;
import Repository.LaptopRepository;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class InputPanel extends JFrame{
    private JButton btnCalculator;
    private JButton btnTelevizor;
    private JButton btnLaptop;
    private JButton btnTelefon;
    private JButton btnMonitor;
    private JPanel mainPanel;
    private JPanel btnsPanel;
    private JPanel titlePanel;

    public InputPanel() {

        setTitle("Magazin SAW");
        setMinimumSize(new Dimension(800, 600));
        setSize(2000,2000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnCalculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creează și deschide o nouă instanță a CalculatorInputPanel
                JFrame calculatorFrame = new JFrame("Calculator Input Panel");
                setMinimumSize(new Dimension(1800, 1600));
                setSize(2000,2000);
                calculatorFrame.setContentPane(new CalculatorInputPanel().getMainPanel());
                calculatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                calculatorFrame.pack();
                calculatorFrame.setLocationRelativeTo(null); // Poziționează fereastra în centru
                calculatorFrame.setVisible(true);
            }
        });

        btnLaptop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnMonitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnTelefon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnTelevizor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Magazin SAW");
        frame.setMinimumSize(new Dimension(300, 200));
        frame.setSize(500,350);
        frame.setContentPane(new InputPanel().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Poziționează fereastra în centru
        frame.setVisible(true);

    }
}

/*class CalculatorInputPanel extends JPanel {
                    private JTextField producatorField, modelField, pretField, tipProcesorField, placaVideoField, memorieRAMField, sistemOperareField, tipStocareField;;
                    private JTextArea resultArea;
                    private Connection connection;
                    private CalculatorRepository calculatorRepo;

                    public CalculatorInputPanel() {
                        setLayout(new GridLayout(0, 2));

                        // Câmpuri de input
                        add(new JLabel("Model:"));
                        modelField = new JTextField();
                        add(modelField);

                        add(new JLabel("Preț:"));
                        pretField = new JTextField();
                        add(pretField);

                        add(new JLabel("Tip procesor:"));
                        tipProcesorField = new JTextField();
                        add(tipProcesorField);

                        add(new JLabel("Placa video:"));
                        placaVideoField = new JTextField();
                        add(placaVideoField);

                        add(new JLabel("Memorie RAM:"));
                        memorieRAMField = new JTextField();
                        add(memorieRAMField);

                        add(new JLabel("Sistem de operare:"));
                        sistemOperareField = new JTextField();
                        add(sistemOperareField);

                        add(new JLabel("Tip stocare:"));
                        tipStocareField = new JTextField();
                        add(tipStocareField);

                        // Butoane CRUD
                        JButton createButton = new JButton("Create");
                        createButton.addActionListener(new CreateAction());
                        add(createButton);

                        // ... (similar pentru Read, Update, Delete)

                        // Conexiune la baza de date
                        try {
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/numele_bazei_de_date", "root", "root");
                            calculatorRepo = new CalculatorRepository(connection);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    class CreateAction implements ActionListener {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String model = modelField.getText();
                            double pret = Double.parseDouble(pretField.getText());
                            String tipProcesor= tipProcesorField.getText();
                            String placaVideo = placaVideoField.getText();
                            String memorieRAM = sistemOperareField.getText();
                            String sistemOperare = sistemOperareField.getText();
                            String tipStocare=tipStocareField.getText();
                            LocalDate creationDate=LocalDate.now();
                            Calculator calculator = new Calculator(model, pret, tipProcesor, placaVideo, memorieRAM, sistemOperare, tipStocare, creationDate );
                            calculatorRepo.createCalculator(calculator);
                            resultArea.setText("Calculator adăugat cu succes!");
                        }
                    }
                }
            }
        });
        btnLaptop.addActionListener(new ActionListener() {

            class LaptopInputPanel extends JPanel {
                private JTextField producatorField, modelField, pretField;
                private JTextArea resultArea;
                private Connection connection;
                private LaptopRepository laptopRepo;

                public LaptopInputPanel() {
                    setLayout(new GridLayout(0, 2));

                    // Câmpuri de input
                    add(new JLabel("Producător:"));
                    producatorField = new JTextField();
                    add(producatorField);

                    add(new JLabel("Model:"));
                    modelField = new JTextField();
                    add(modelField);

                    add(new JLabel("Preț:"));
                    pretField = new JTextField();
                    add(pretField);

                    // Butoane CRUD
                    JButton createButton = new JButton("Create");
                    createButton.addActionListener(new CreateAction());
                    add(createButton);

                    // ... (similar pentru Read, Update, Delete)

                    // Conexiune la baza de date
                    try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/numele_bazei_de_date", "utilizator", "parola");
                        laptopRepo = new LaptopRepository(connection);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void actionPerformed(ActionEvent e) {
                    String producator = producatorField.getText();
                    String model = modelField.getText();
                    double pret = Double.parseDouble(pretField.getText());
                    Laptop laptop = new Laptop(producator, model, pret, LocalDate.now());
                    laptopRepo.createLaptop(laptop);
                    resultArea.setText("Laptop adăugat cu succes!");

                }
            }
        });
        btnMonitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnTelefon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnTelevizor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }*/