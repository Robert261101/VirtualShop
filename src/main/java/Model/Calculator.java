package Model;

import java.time.LocalDate;

public class Calculator {
    private String model;
    private double pret;
    private String tipProcesor;
    private String placaVideo;
    private String memorieRAM;
    private String sistemOperare;
    private String tipStocare;
    private LocalDate creationDate;

    public Calculator(String model, double pret, String tipProcesor, String placaVideo, String memorieRAM, String sistemOperare, String tipStocare, LocalDate creationDate) {
        this.model = model;
        this.pret = pret;
        this.tipProcesor = tipProcesor;
        this.placaVideo = placaVideo;
        this.memorieRAM = memorieRAM;
        this.sistemOperare = sistemOperare;
        this.tipStocare = tipStocare;
        this.creationDate = creationDate;
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

    public String getPlacaVideo() {
        return placaVideo;
    }

    public void setPlacaVideo(String placaVideo) {
        this.placaVideo = placaVideo;
    }

    public String getMemorieRAM() {
        return memorieRAM;
    }

    public void setMemorieRAM(String memorieRAM) {
        this.memorieRAM = memorieRAM;
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
