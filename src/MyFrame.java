import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyFrame extends JFrame implements ActionListener{
    private BankkontoSystem bankSystem;
    int auswahl = 0;

    JPanel screenPanelIn; //inner panel
    JPanel screenPanelOut; //outer panel
    JPanel screenBorderedPanel;
    JPanel calcPanelIn;
    JPanel calcPanelOut;
    JPanel calcBorderedPanel;
    JPanel backPanel; //background panel

    //JTextField pinFieldTxt;
    JTextField curBalanceTxt;
    JTextField eingabeBalanceTxt;

    JLabel updateBalanceLabel;

    JButton einzahlenButton;
    JButton auszahlenButton;
    JButton beendenButton;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[6];
    JButton enterButton, cancelButton, clearButton, dotButton, OOButton, okButton; 

    boolean dotButtonUsed = false; //to check if dot button is used
    MyFrame() {
        bankSystem = new BankkontoSystem();

        //PIN layout
        // JLabel label1 = new JLabel();
        // label1.setOpaque(true);
        // label1.setBackground(Color.RED);
        // label1.setBounds(40, 33, 500, 310);
        // JLayeredPane layeredPane = new JLayeredPane();
        // layeredPane.setBounds(0, 0, 560, 410);
        // layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
        
        // pinFieldTxt = new JTextField();
        // pinFieldTxt.setBounds(30, 300, 150, 35);
        // pinFieldTxt.setFont(new Font("Arial", Font.BOLD, 28));


        //text field layout
        curBalanceTxt = new JTextField();
        curBalanceTxt.setBounds(370, 60, 150, 35);
        curBalanceTxt.setFont(new Font("Consolas", Font.BOLD, 30));
        curBalanceTxt.setEditable(false);
        curBalanceTxt.setFocusable(false);
        curBalanceTxt.setText(String.valueOf(bankSystem.getKontostand()));
        

        eingabeBalanceTxt = new JTextField();
        eingabeBalanceTxt.setBounds(370, 110, 150, 35);
        eingabeBalanceTxt.setFont(new Font("Consolas", Font.BOLD, 30));
        eingabeBalanceTxt.setEditable(false);
        eingabeBalanceTxt.setFocusable(false);


        //buttons layout
        einzahlenButton = new JButton("Einzahlen");
        einzahlenButton.setBounds(54, 270, 150, 40);
        einzahlenButton.setFont(new Font("Arial", Font.BOLD, 25));
        einzahlenButton.addActionListener(this);
        einzahlenButton.setFocusable(false);
        einzahlenButton.setBackground(new Color (189, 194, 228));
        einzahlenButton.setBorder(BorderFactory.createEtchedBorder());

        auszahlenButton = new JButton("Auszahlen");
        auszahlenButton.setBounds(214, 270, 150, 40);
        auszahlenButton.setFont(new Font("Arial", Font.BOLD, 25));
        auszahlenButton.addActionListener(this);
        auszahlenButton.setFocusable(false);
        auszahlenButton.setBackground(new Color (189, 194, 228));
        auszahlenButton.setBorder(BorderFactory.createEtchedBorder());

        beendenButton = new JButton("Beenden");
        beendenButton.setBounds(374, 270, 150, 40);
        beendenButton.setFont(new Font("Arial", Font.BOLD, 25));
        beendenButton.addActionListener(this);
        beendenButton.setFocusable(false);
        beendenButton.setBackground(new Color (189, 194, 228));
        beendenButton.setBorder(BorderFactory.createEtchedBorder());

        //calculator buttons layout
        enterButton = new JButton("Enter");
        cancelButton = new JButton("Cancel"); 
        clearButton = new JButton("Clear");
        dotButton = new JButton(".");
        OOButton = new JButton("00");
        okButton = new JButton("OK");
        functionButtons[0] = enterButton;
        functionButtons[1] = cancelButton;
        functionButtons[2] = clearButton;
        functionButtons[3] = dotButton;
        functionButtons[4] = OOButton;
        functionButtons[5] = okButton;
        
        for (int i = 0; i < 6; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 28));
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBorder(BorderFactory.createEtchedBorder()); 
        } 
        functionButtons[0].setBackground(new Color(0, 215, 70));
        functionButtons[1].setBackground(new Color(225, 0, 70));
        functionButtons[2].setBackground(new Color(215, 215, 70));
        functionButtons[3].setBackground(new Color(150, 150,150));
        functionButtons[4].setBackground(new Color(150, 150,150));
        functionButtons[5].setBackground(new Color(189, 194, 228));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 28));
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBorder(BorderFactory.createEtchedBorder());
            numberButtons[i].setBackground(new Color(150, 150,150));
        }
        
        JPanel calc = new JPanel();
        calc.setBounds(40, 390, 500, 310);
        calc.setLayout(new GridLayout(4,4,10,10));
        calc.add(numberButtons[1]);
        calc.add(numberButtons[2]);
        calc.add(numberButtons[3]);
        calc.add(enterButton);
        calc.add(numberButtons[4]);
        calc.add(numberButtons[5]);
        calc.add(numberButtons[6]);
        calc.add(cancelButton);
        calc.add(numberButtons[7]);
        calc.add(numberButtons[8]);
        calc.add(numberButtons[9]);
        calc.add(clearButton);
        calc.add(dotButton);
        calc.add(numberButtons[0]);
        calc.add(OOButton);
        calc.add(okButton);
        

        //background layouß
        backPanel = new JPanel();
        backPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        backPanel.setBounds(0, 0, 582, 740);


        //screen layout
        screenPanelIn = new JPanel();
        screenPanelIn.setBackground(new Color(119, 124, 158));
        screenPanelIn.setBounds(40, 33, 500, 310);

        JLabel curBalanceLabel = new JLabel("Kontostand:");
        curBalanceLabel.setBounds(20, 29, 400, 30);
        curBalanceLabel.setFont(new Font("Arial", Font.BOLD, 25));
        curBalanceLabel.setForeground(Color.BLACK);

        JLabel withdrwBalanceLabel = new JLabel("Eingabe:");
        withdrwBalanceLabel.setBounds(20, 81, 400, 30); 
        withdrwBalanceLabel.setFont(new Font("Arial", Font.BOLD, 25));
        withdrwBalanceLabel.setForeground(Color.BLACK);

        updateBalanceLabel = new JLabel();
        updateBalanceLabel.setText("Wählen Sie eine Option");
        updateBalanceLabel.setBounds(120, 181, 400, 30); 
        updateBalanceLabel.setFont(new Font("Arial", Font.BOLD, 25));
        updateBalanceLabel.setForeground(Color.BLACK);

        screenPanelIn.setLayout(null); 
        screenPanelIn.add(curBalanceLabel);
        screenPanelIn.add(withdrwBalanceLabel);
        screenPanelIn.add(updateBalanceLabel);

        screenPanelOut = new JPanel();
        screenPanelOut.setBackground(new Color(238, 238, 238));
        screenPanelOut.setBounds(12, 12, 556, 346);

        screenBorderedPanel = new JPanel();
        screenBorderedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        screenBorderedPanel.setBounds(10, 10, 560, 350);


        //calculator layout
        calcPanelIn = new JPanel();
        calcPanelIn.setBackground(new Color(119, 124, 158));
        calcPanelIn.setBounds(screenPanelIn.getX(), screenPanelIn.getY() + screenPanelIn.getHeight() + 50, 500, 300);
        
        calcPanelOut = new JPanel();
        calcPanelOut.setBackground(new Color(238, 238, 238));
        calcPanelOut.setBounds(screenPanelOut.getX(), screenPanelOut.getY() + screenPanelOut.getHeight() + 14, 556, 355);
        
        calcBorderedPanel = new JPanel();
        calcBorderedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        calcBorderedPanel.setBounds(screenBorderedPanel.getX(), screenBorderedPanel.getY() + screenBorderedPanel.getHeight() + 10, 560, 360);


        this.setTitle("Bankkonto System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(598, 780);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setAlwaysOnTop(true);
        this.setLayout(null);

        // this.add(layeredPane);
        // this.add(pinFieldTxt);

        //caclulator panel
        this.add(calc);

        //text field layout
        this.add(curBalanceTxt);
        this.add(eingabeBalanceTxt);

        //screen button layout
        this.add(einzahlenButton);
        this.add(auszahlenButton);
        this.add(beendenButton);

        //screen layout
        this.add(screenPanelIn);
        this.add(screenPanelOut);
        this.add(screenBorderedPanel);

        //calculator layout
        this.add(calcPanelIn);
        this.add(calcPanelOut);
        this.add(calcBorderedPanel);
        
        //background layout
        this.add(backPanel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eingabe = eingabeBalanceTxt.getText();

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (eingabe.contains(".")) {
                    if (eingabe.substring(eingabe.indexOf(".")).length() < 3) {
                        eingabeBalanceTxt.setText(eingabe + i);
                    } //nichts tun, wenn schon 2 nachkommastellen da sind
                } else {
                    eingabeBalanceTxt.setText(eingabe + i);
                } 
            }
        }

        if (e.getSource() == einzahlenButton) {
            if (auswahl == 0) {
                auswahl = 1;
                System.out.println("Einzahlen gedruckt " + auswahl);
            }
        }

        if (e.getSource() == auszahlenButton) {
            if (auswahl == 0) {
                auswahl = 2;
                System.out.println("Einzahlen gedruckt " + auswahl);
                System.out.println(auswahl);
            }
        }

        if (e.getSource() == beendenButton) {
            System.exit(0);
        }

        if (e.getSource() == enterButton) {
            double betrag = Double.parseDouble(eingabe);
            switch (auswahl) {
                case 1:
                    bankSystem.einzahlen(betrag);
                    curBalanceTxt.setText(String.valueOf(bankSystem.getKontostand()));
                    eingabeBalanceTxt.setText("");
                    updateBalanceLabel.setText("Einzahlen Updated");
                    break;  
                case 2:
                    bankSystem.auszahlen(betrag);
                    curBalanceTxt.setText(String.valueOf(bankSystem.getKontostand()));
                    eingabeBalanceTxt.setText("");
                    updateBalanceLabel.setText("Auszahlen Updated");
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }
            auswahl = 0;
        }

        if (e.getSource() == cancelButton) {
            auswahl = 0;
            eingabeBalanceTxt.setText("");
            updateBalanceLabel.setText("Wählen Sie eine Option");
        }

        if (e.getSource() == clearButton) {
            eingabeBalanceTxt.setText("");
            dotButtonUsed = false;
        }

        if (e.getSource() == dotButton) {
            if (dotButtonUsed == false) {
                eingabeBalanceTxt.setText(eingabe.concat("."));
                dotButtonUsed = true;
            }
        }

        if (e.getSource() == OOButton) {
            if (dotButtonUsed == false) {
                eingabeBalanceTxt.setText(eingabe.concat("00"));
            } 
        }
    }
}