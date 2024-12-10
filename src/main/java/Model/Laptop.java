package Model;

import java.time.LocalDate;

public class Laptop {
    private String producator;
    private String model;
    private double pret;
    private String tipProcesor;
    private String memorieRAM;
    private int dimensiuneDiagonala;
    private String sistemOperare;
    private String tipStocare;
    private LocalDate creationDate;

    public Laptop(String producator, String model, double pret, String tipProcesor, String memorieRAM, int dimensiuneDiagonala, String sistemOperare, String tipStocare, LocalDate creationDate) {
        this.producator = producator;
        this.model = model;
        this.pret = pret;
        this.tipProcesor = tipProcesor;
        this.memorieRAM = memorieRAM;
        this.dimensiuneDiagonala = dimensiuneDiagonala;
        this.sistemOperare = sistemOperare;
        this.tipStocare = tipStocare;
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

    public String getTipProcesor() {
        return tipProcesor;
    }

    public void setTipProcesor(String tipProcesor) {
        this.tipProcesor = tipProcesor;
    }

    public String getMemorieRAM() {
        return memorieRAM;
    }

    public void setMemorieRAM(String memorieRAM) {
        this.memorieRAM = memorieRAM;
    }

    public int getDimensiuneDiagonala() {
        return dimensiuneDiagonala;
    }

    public void setDimensiuneDiagonala(int dimensiuneDiagonala) {
        this.dimensiuneDiagonala = dimensiuneDiagonala;
    }

    public String getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(String sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    public String getTipStocare() {
        return tipStocare;
    }

    public void setTipStocare(String tipStocare) {
        this.tipStocare = tipStocare;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
