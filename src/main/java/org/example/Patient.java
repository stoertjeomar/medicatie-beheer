package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Persoon {
    private List<Medicatie> medicatieLijst;
    private List<Zorgverlener> gemachtigdeZorgverleners;
    private List<Familielid> gekoppeldeFamilieleden;
    private ToegankelijkheidsInstellingen instellingen;

    public Patient(String naam, String id) {
        super(naam, id);
        this.medicatieLijst = new ArrayList<>();
        this.gemachtigdeZorgverleners = new ArrayList<>();
        this.gekoppeldeFamilieleden = new ArrayList<>();
        this.instellingen = new ToegankelijkheidsInstellingen();
    }

    public void voegMedicatieToe(Medicatie medicatie) {
        medicatieLijst.add(medicatie);
    }

    public void koppelFamilielid(Familielid familielid) {
        gekoppeldeFamilieleden.add(familielid);
    }

    public void machtigZorgverlener(Zorgverlener zorgverlener) {
        gemachtigdeZorgverleners.add(zorgverlener);
    }

    @Override
    public void ontvangMelding(String bericht) {
        System.out.println("Melding voor " + naam + ": " + bericht);
    }

    public List<Medicatie> getMedicatieLijst() {
        return medicatieLijst;
    }

    public ToegankelijkheidsInstellingen getInstellingen() {
        return instellingen;
    }

    public List<Familielid> getGekoppeldeFamilieleden() {
        return gekoppeldeFamilieleden;
    }
}