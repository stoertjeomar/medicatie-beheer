package org.example;

public class Familielid extends Persoon {
    private String relatieMetPatient;

    public Familielid(String naam, String id, String relatieMetPatient) {
        super(naam, id);
        this.relatieMetPatient = relatieMetPatient;
    }

    @Override
    public void ontvangMelding(String bericht) {
        System.out.println("Urgente melding voor familielid " + naam + ": " + bericht);
    }

    public String getRelatieMetPatient() {
        return relatieMetPatient;
    }
}