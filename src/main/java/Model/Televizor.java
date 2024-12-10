package Model;

import java.time.LocalDate;

public class Televizor {
    private String producator;
    private String model;
    private double pret;
    private int dimensiuneDiagonala;
    private String tehnologieDisplay;
    private String claritateImagine;
    private String clasaEnergetica;
    private LocalDate creationDate;

    public Televizor(String producator, String model, double pret, int dimensiuneDiagonala, String tehnologieDisplay, String claritateImagine, String clasaEnergetica, LocalDate creationDate) {
        this.producator = producator;
        this.model = model;
        this.pret = pret;
        this.dimensiuneDiagonala = dimensiuneDiagonala;
        this.tehnologieDisplay = tehnologieDisplay;
        this.claritateImagine = claritateImagine;
        this.clasaEnergetica = clasaEnergetica;
        this.creationDate = creationDate;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getDimensiuneDiagonala() {
        return dimensiuneDiagonala;
    }

    public void setDimensiuneDiagonala(int dimensiuneDiagonala) {
        this.dimensiuneDiagonala = dimensiuneDiagonala;
    }

    public String getTehnologieDisplay() {
        return tehnologieDisplay;
    }

    public void setTehnologieDisplay(String tehnologieDisplay) {
        this.tehnologieDisplay = tehnologieDisplay;
    }

    public String getClaritateImagine() {
        return claritateImagine;
    }

    public void setClaritateImagine(String claritateImagine) {
        this.claritateImagine = claritateImagine;
    }

    public String getClasaEnergetica() {
        return clasaEnergetica;
    }

    public void setClasaEnergetica(String clasaEnergetica) {
        this.clasaEnergetica = clasaEnergetica;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
