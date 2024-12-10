package Model;

import java.time.LocalDate;

public class Monitor {
    private String producator;
    private String model;
    private double pret;
    private int dimensiuneDiagonala;
    private int rataRefresh;
    private LocalDate creationDate;

    public Monitor(String producator, String model, double pret, int dimensiuneDiagonala, int rataRefresh, LocalDate creationDate) {
        this.producator = producator;
        this.model = model;
        this.pret = pret;
        this.dimensiuneDiagonala = dimensiuneDiagonala;
        this.rataRefresh = rataRefresh;
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

    public int getRataRefresh() {
        return rataRefresh;
    }

    public void setRataRefresh(int rataRefresh) {
        this.rataRefresh = rataRefresh;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
