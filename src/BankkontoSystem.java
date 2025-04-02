public class BankkontoSystem {
        private double kontostand = 100.00;
  
        public void einzahlen(double betrag) {
            if (betrag > 0) {
                kontostand += betrag;
            } 
        }
    
        public void auszahlen(double betrag) {
            if (betrag > 0 && betrag <= kontostand) {
                kontostand -= betrag;
            } 
        }
    
        public double getKontostand() {
            return kontostand;
        }
}


