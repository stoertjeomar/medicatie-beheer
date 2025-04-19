package org.example;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class MedicatieHerinneringService {
    private Patient patient;
    private Timer timer;

    public MedicatieHerinneringService(Patient patient) {
        this.patient = patient;
        this.timer = new Timer();
    }

    public void startHerinneringen() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                controleerMedicatie();
            }
        }, 0, 60000); // Controleert elke minuut
    }

    private void controleerMedicatie() {
        LocalTime nuTijd = LocalTime.now();
        for (Medicatie med : patient.getMedicatieLijst()) {
            if (!med.isVerwijderd() && !med.isIngenomen() && med.getTijdstip().equals(nuTijd)) {
                stuurHerinnering(med);
                startFamilieTimer(med);
            }
        }
    }

    private void stuurHerinnering(Medicatie med) {
        patient.ontvangMelding("Het is tijd om " + med.getNaam() + " in te nemen!");
    }

    private void startFamilieTimer(Medicatie med) {
        Timer familieTimer = new Timer();
        familieTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!med.isIngenomen()) {
                    waarschuwFamilieleden(med);
                }
            }
        }, 900000); // 15 minuten wachten
    }

    private void waarschuwFamilieleden(Medicatie med) {
        String bericht = "Let op: " + patient.getNaam() + " heeft " + med.getNaam() + " nog niet ingenomen!";
        for (Familielid familielid : patient.getGekoppeldeFamilieleden()) {
            familielid.ontvangMelding(bericht);
        }
    }
}