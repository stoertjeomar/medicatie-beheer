package org.example;

public class Zorgverlener extends Persoon {
    private String functie;
    private boolean isGemachtigd;

    public Zorgverlener(String naam, String id, String functie) {
        super(naam, id);
        this.functie = functie;
        this.isGemachtigd = false;
    }

    @Override
    public void ontvangMelding(String bericht) {
        System.out.println("Medische melding voor zorgverlener " + naam + ": " + bericht);
    }

    public void setGemachtigd(boolean gemachtigd) {
        this.isGemachtigd = gemachtigd;
    }

    public boolean isGemachtigd() {
        return isGemachtigd;
    }
}