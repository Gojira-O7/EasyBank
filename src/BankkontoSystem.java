import java.util.Scanner;

import javax.swing.JFrame;

public class BankkontoSystem {
    Scanner scanner = new Scanner(System.in);
    int zahl;
    double betrag;

    BankkontoSystem() {
        Konto konto = new Konto("999999", "Silas Luedtke", 100.0);
        while (true) { 
            System.out.println("Wähle eine Option");
            System.out.println("[1] Auszahlen, [2] Einzahlen, [3] Kontostand Anzeigen, [4] Beenden ");
            System.out.println(" ");
            zahl = scanner.nextInt();
            
            switch (zahl) {
                case 1:
                    System.out.println("Kontostand: " + konto.getKontostand());
                    System.out.print("Gib den Betrag ein, den du auszahlen möchtest: ");
                    betrag = scanner.nextDouble();
                    konto.auszahlen(betrag);
                    break;
                case 2:
                    System.out.print("Gib den Betrag ein, den du einzahlen willst: ");
                    betrag = scanner.nextDouble();
                    konto.einzahlen(betrag);
                    break;
                case 3:
                    System.out.print("Kontostand: " + konto.getKontostand());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error! Bitte verwenden 1, 2, 3 oder 4 als Eingabe.");
            }
            scanner.close();
            break;
        }
    }

    class Konto {
        private String kontonummer;
        private String kontoinhaber;
        private double kontostand;
    
        //konstruktor
        public Konto(String kontonummer, String kontoinhaber, double startKontostand) {
            this.kontonummer = kontonummer;
            this.kontoinhaber = kontoinhaber;
            this.kontostand = startKontostand;
        }
    
        public void einzahlen(double betrag) {
            if (betrag > 0) {
                kontostand += betrag;
                System.out.println("Eingezahlt: " + betrag);
            } else {
                System.out.println("Ungültiger Betrag.");
            }
        }
    
        public void auszahlen(double betrag) {
            if (betrag > 0 && betrag <= kontostand) {
                kontostand -= betrag;
                System.out.println(betrag + "€ ausgezahlt.");
            } else {
                System.out.println("Ungültiger Betrag oder nicht genug Guthaben.");
            }
        }
    
        public double getKontostand() {
            return kontostand;
        }
    }
}


