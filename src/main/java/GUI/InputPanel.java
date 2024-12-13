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
                JFrame laptopFrame = new JFrame("Laptop Input Panel");
                setMinimumSize(new Dimension(1800, 1600));
                setSize(2000,2000);
                laptopFrame.setContentPane(new LaptopInputPanel().getMainPanel());
                laptopFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                laptopFrame.pack();
                laptopFrame.setLocationRelativeTo(null); // Poziționează fereastra în centru
                laptopFrame.setVisible(true);
            }
        });

        btnMonitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame monitorFrame = new JFrame("Monitor Input Panel");
                setMinimumSize(new Dimension(1800, 1600));
                setSize(2000,2000);
                monitorFrame.setContentPane(new MonitorInputPanel().getMainPanel());
                monitorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                monitorFrame.pack();
                monitorFrame.setLocationRelativeTo(null); // Poziționează fereastra în centru
                monitorFrame.setVisible(true);
            }
        });
        btnTelefon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame telefonFrame = new JFrame("Telefon Input Panel");
                setMinimumSize(new Dimension(1800, 1600));
                setSize(2000,2000);
                telefonFrame.setContentPane(new TelefonInputPanel().getMainPanel());
                telefonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                telefonFrame.pack();
                telefonFrame.setLocationRelativeTo(null); // Poziționează fereastra în centru
                telefonFrame.setVisible(true);
            }
        });
        btnTelevizor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame televizorFrame = new JFrame("Televizor Input Panel");
                setMinimumSize(new Dimension(1800, 1600));
                setSize(2000,2000);
                televizorFrame.setContentPane(new TelevizorInputPanel().getMainPanel());
                televizorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                televizorFrame.pack();
                televizorFrame.setLocationRelativeTo(null); // Poziționează fereastra în centru
                televizorFrame.setVisible(true);
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