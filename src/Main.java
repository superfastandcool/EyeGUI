package src;
import java.awt.*;
import javax.swing.*;


public class Main{
    
    public static void main(String[] args) {


        JFrame frame = new JFrame("Break");

        JPanel CardLayoutPanel = new JPanel();
        CardLayoutPanel.setLayout(new CardLayout());


        OpeningPanel openingPanel = new OpeningPanel(CardLayoutPanel);
        CardLayoutPanel.add(openingPanel, "TheOpeningCard");

        WorkPanel workPanel = new WorkPanel(CardLayoutPanel);
        CardLayoutPanel.add(workPanel, "TheWorkCard");


        frame.add(CardLayoutPanel);
        


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        // frame.pack();
        frame.setVisible(true);
    }


}