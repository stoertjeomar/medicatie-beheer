package org.example;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Patient patient;

    public static void main(String[] args) {
        System.out.println("Voer de naam van de gebruiker in:");
        String naam = scanner.nextLine();
        patient = new Patient(naam, "P001");  // ID wordt automatisch toegewezen

        boolean doorgaan = true;
        while (doorgaan) {
            toonMenu();
            int keuze = Integer.parseInt(scanner.nextLine());

            switch (keuze) {
                case 1 -> voegMedicatieToe();
                case 2 -> voegFamilielidToe();
                case 3 -> toonInstellingen();
                case 4 -> toonOverzicht();
                case 5 -> {
                    System.out.println("Programma wordt afgesloten...");
                    doorgaan = false;
                }
                default -> System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
        scanner.close();
    }

    private static void toonMenu() {
        System.out.println("\n=== MEDICATIE HERINNERING MENU ===");
        System.out.println("1. Medicatie toevoegen");
        System.out.println("2. Familielid toevoegen");
        System.out.println("3. Instellingen aanpassen");
        System.out.println("4. Overzicht bekijken");
        System.out.println("5. Afsluiten");
        System.out.println("Maak uw keuze (1-5):");
    }

    private static void voegMedicatieToe() {
        System.out.println("\n== MEDICATIE TOEVOEGEN ==");
        System.out.println("Naam medicijn:");
        String medicijnNaam = scanner.nextLine();
        
        System.out.println("Dosering (bijvoorbeeld: 500mg):");
        String dosering = scanner.nextLine();
        
        System.out.println("Tijdstip van inname (uur):");
        int uur = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Tijdstip van inname (minuten):");
        int minuten = Integer.parseInt(scanner.nextLine());

        Medicatie medicatie = new Medicatie(medicijnNaam, dosering, LocalTime.of(uur, minuten));
        patient.voegMedicatieToe(medicatie);
        System.out.println("Medicatie is succesvol toegevoegd!");
    }

    private static void voegFamilielidToe() {
        System.out.println("\n== FAMILIELID TOEVOEGEN ==");
        System.out.println("Naam familielid:");
        String familieNaam = scanner.nextLine();
        
        System.out.println("Relatie (bijvoorbeeld: Partner, Zoon, Dochter):");
        String relatie = scanner.nextLine();

        Familielid familielid = new Familielid(familieNaam, "F" + (patient.getGekoppeldeFamilieleden().size() + 1), relatie);
        patient.koppelFamilielid(familielid);
        System.out.println("Familielid is succesvol toegevoegd!");
    }

    private static void toonInstellingen() {
        System.out.println("\n== INSTELLINGEN ==");
        ToegankelijkheidsInstellingen instellingen = patient.getInstellingen();
        
        System.out.println("Groot lettertype gebruiken? (ja/nee):");
        instellingen.setGrootLettertype(scanner.nextLine().toLowerCase().equals("ja"));
        
        System.out.println("Audio meldingen gebruiken? (ja/nee):");
        instellingen.setAudioMeldingen(scanner.nextLine().toLowerCase().equals("ja"));
        
        System.out.println("Instellingen zijn opgeslagen!");
    }

    private static void toonOverzicht() {
        System.out.println("\n== OVERZICHT ==");
        System.out.println("Gebruiker: " + patient.getNaam());
        
        System.out.println("\nMedicatielijst:");
        if (patient.getMedicatieLijst().isEmpty()) {
            System.out.println("Geen medicatie toegevoegd");
        } else {
            for (Medicatie med : patient.getMedicatieLijst()) {
                System.out.println("- " + med.getNaam() + " (" + med.getDosering() + ") om " + med.getTijdstip());
            }
        }

        System.out.println("\nGekoppelde familieleden:");
        if (patient.getGekoppeldeFamilieleden().isEmpty()) {
            System.out.println("Geen familieleden toegevoegd");
        } else {
            for (Familielid familielid : patient.getGekoppeldeFamilieleden()) {
                System.out.println("- " + familielid.getNaam() + " (" + familielid.getRelatieMetPatient() + ")");
            }
        }

        ToegankelijkheidsInstellingen inst = patient.getInstellingen();
        System.out.println("\nInstellingen:");
        System.out.println("- Groot lettertype: " + (inst.isGrootLettertype() ? "Aan" : "Uit"));
        System.out.println("- Audio meldingen: " + (inst.isAudioMeldingen() ? "Aan" : "Uit"));
    }
}