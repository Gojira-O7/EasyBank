import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class MyFrame extends JFrame {
    MyFrame() {
        JPanel backPanel = new JPanel();
        backPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        backPanel.setBounds(0, 0, 582, 740);

        //screen layout
        JPanel screenPanelIn = new JPanel();
        screenPanelIn.setBackground(new Color(0x000099));
        screenPanelIn.setBounds(40, 30, 500, 310);

        JPanel screenPanelOut = new JPanel();
        screenPanelOut.setBackground(new Color(238, 238, 238));
        screenPanelOut.setBounds(12, 12, 556, 346);

        JPanel screenBorderedPanel = new JPanel();
        screenBorderedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        screenBorderedPanel.setBounds(10, 10, 560, 350);


        //calculator layout
        JPanel calcPanelIn = new JPanel();
        calcPanelIn.setBackground(new Color(0x777C9E));
        calcPanelIn.setBounds(screenPanelIn.getX(), screenPanelIn.getY() + screenPanelIn.getHeight() + 50, 500, 310);

        JPanel calcPanelOut = new JPanel();
        calcPanelOut.setBackground(new Color(238, 238, 238));
        calcPanelOut.setBounds(screenPanelOut.getX(), screenPanelOut.getY() + screenPanelOut.getHeight() + 14, 556, 355);

        JPanel calcBorderedPanel = new JPanel();
        calcBorderedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        calcBorderedPanel.setBounds(screenBorderedPanel.getX(), screenBorderedPanel.getY() + screenBorderedPanel.getHeight() + 10, 560, 360);

        

        this.setTitle("Bankkonto System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(598, 780);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.setVisible(true);

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
        
    }
}
