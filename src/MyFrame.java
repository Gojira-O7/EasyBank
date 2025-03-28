import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyFrame extends JFrame implements ActionListener{
    JPanel screenPanelIn; //inner panel
    JPanel screenPanelOut; //outer panel
    JPanel screenBorderedPanel;
    JPanel calcPanelIn;
    JPanel calcPanelOut;
    JPanel calcBorderedPanel;
    JPanel backPanel; //background panel
    

    JTextField curBalanceTxt;
    JTextField withdrwBalanceTxt;

    JButton receiptButton;
    JButton backButton;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[6];
    JButton enterButton, cancelButton, clearButton, dotButton, OOButton, okButton; 

    MyFrame() {
        setupBankUi();

    }

    public void setupBankUi() {

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(40, 33, 500, 310);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 560, 410);
        layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);


        //text field layout
        curBalanceTxt = new JTextField();
        curBalanceTxt.setBounds(370, 60, 150, 35);
        curBalanceTxt.setFont(new Font("Arial", Font.BOLD, 28));
        curBalanceTxt.setEditable(false);
        curBalanceTxt.setFocusable(false);
        

        withdrwBalanceTxt = new JTextField();
        withdrwBalanceTxt.setBounds(370, 110, 150, 35);
        withdrwBalanceTxt.setFont(new Font("Arial", Font.BOLD, 28));
        withdrwBalanceTxt.setEditable(false);
        withdrwBalanceTxt.setFocusable(false);


        //buttons layout
        receiptButton = new JButton("Receipt");
        receiptButton.setBounds(370, 190, 150, 40);
        receiptButton.setFont(new Font("Arial", Font.BOLD, 28));
        receiptButton.addActionListener(this);
        receiptButton.setFocusable(false);
        receiptButton.setBackground(new Color (189, 194, 228));
        receiptButton.setBorder(BorderFactory.createEtchedBorder());

        backButton = new JButton("Back");
        backButton.setBounds(370, 270, 150, 40);
        backButton.setFont(new Font("Arial", Font.BOLD, 28));
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setBackground(new Color (189, 194, 228));
        backButton.setBorder(BorderFactory.createEtchedBorder());

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
            functionButtons[0].setBackground(new Color(0, 215, 70));
            functionButtons[1].setBackground(new Color(225, 0, 70));
            functionButtons[2].setBackground(new Color(215, 215, 70));
            functionButtons[3].setBackground(new Color(150, 150,150));
            functionButtons[4].setBackground(new Color(150, 150,150));
            functionButtons[5].setBackground(new Color(189, 194, 228)); 
        } 
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
        JLabel curBalanceLabel = new JLabel("Current Balance:");
        curBalanceLabel.setBounds(20, 29, 400, 30);
        curBalanceLabel.setFont(new Font("Arial", Font.BOLD, 28)); 
        JLabel withdrwBalanceLabel = new JLabel("Withdrawal Balance: ");
        withdrwBalanceLabel.setBounds(20, 81, 400, 30); 
        withdrwBalanceLabel.setFont(new Font("Arial", Font.BOLD, 28)); 
        screenPanelIn.setLayout(null); 
        screenPanelIn.add(curBalanceLabel);
        screenPanelIn.add(withdrwBalanceLabel);

        screenPanelOut = new JPanel();
        screenPanelOut.setBackground(new Color(238, 238, 238));
        screenPanelOut.setBounds(12, 12, 556, 346);

        screenBorderedPanel = new JPanel();
        screenBorderedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        screenBorderedPanel.setBounds(10, 10, 560, 350);


        //calculator layout
        calcPanelIn = new JPanel();
        calcPanelIn.setBackground(new Color(119, 124, 158));
        calcPanelIn.setBounds(screenPanelIn.getX(), screenPanelIn.getY() + screenPanelIn.getHeight() + 50, 500, 310);
        
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

        this.add(layeredPane);

        //caclulator panel
        this.add(calc);

        //text field layout
        this.add(curBalanceTxt);
        this.add(withdrwBalanceTxt);

        //screen button layout
        this.add(receiptButton);
        this.add(backButton);

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
        if (e.getSource() == receiptButton) {
            System.out.println("Receipt button clicked!");
        }
        if (e.getSource() == backButton) {
            System.out.println("Back button clicked!");
        }
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                withdrwBalanceTxt.setText(withdrwBalanceTxt.getText().concat(String.valueOf(i)));
            }   
        }
        if (e.getSource() == clearButton) {
            withdrwBalanceTxt.setText("");
        }
        if (e.getSource() == cancelButton) {
            withdrwBalanceTxt.setText("");
        }
        if (e.getSource() == receiptButton) {
            System.out.println("Beleg gedruckt für");
        }
        if (e.getSource() == OOButton) {
            withdrwBalanceTxt.setText(withdrwBalanceTxt.getText().concat("00"));
        }
    }
}