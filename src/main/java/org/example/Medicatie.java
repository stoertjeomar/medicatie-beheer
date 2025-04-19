package org.example;

import java.time.LocalTime;
import java.time.LocalDate;

public class Medicatie {
    private String naam;
    private String dosering;
    private LocalTime tijdstip;
    private boolean isIngenomen;
    private boolean isVerwijderd;
    private LocalDate laatsteInname;

    public Medicatie(String naam, String dosering, LocalTime tijdstip) {
        this.naam = naam;
        this.dosering = dosering;
        this.tijdstip = tijdstip;
        this.isIngenomen = false;
        this.isVerwijderd = false;
        this.laatsteInname = null;
    }

    public void bevestigInname() {
        this.isIngenomen = true;
        this.laatsteInname = LocalDate.now();
    }

    public String getNaam() {
        return naam;
    }

    public String getDosering() {
        return dosering;
    }

    public LocalTime getTijdstip() {
        return tijdstip;
    }

    public boolean isIngenomen() {
        return isIngenomen;
    }

    public boolean isVerwijderd() {
        return isVerwijderd;
    }

    public void setVerwijderd(boolean verwijderd) {
        this.isVerwijderd = verwijderd;
    }

    public LocalDate getLaatsteInname() {
        return laatsteInname;
    }
}