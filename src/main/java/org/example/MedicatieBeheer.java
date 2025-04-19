package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MedicatieBeheer {

    private List<Medicatie> medicaties;

    public MedicatieBeheer() {
        medicaties = new ArrayList<>();
    }

    public void voegMedicatieToe(Medicatie medicatie) {
        medicaties.add(medicatie);
    }

    public void controleerMedicatie(LocalTime huidigeTijd) {
        for (Medicatie medicatie : medicaties) {
            if (huidigeTijd.isAfter(medicatie.getTijdstip().minusMinutes(5)) &&
                    huidigeTijd.isBefore(medicatie.getTijdstip().plusMinutes(5))) {
                System.out.println("💊 Tijd om " + medicatie.getNaam() + " in te nemen!");
            } else if (huidigeTijd.isAfter(medicatie.getTijdstip().plusMinutes(5))) {
                System.out.println("⚠️ Dosis van " + medicatie.getNaam() + " gemist!");
            }
        }
    }
}
