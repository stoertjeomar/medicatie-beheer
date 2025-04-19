package org.example;

public abstract class Persoon {
    protected String naam;
    protected String id;

    public Persoon(String naam, String id) {
        this.naam = naam;
        this.id = id;
    }

    public abstract void ontvangMelding(String bericht);

    public String getNaam() {
        return naam;
    }

    public String getId() {
        return id;
    }
}