public class BankkontoSystem {
        private double kontostand = 100.00;
  
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


