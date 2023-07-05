package src;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class OpeningPanel extends JPanel{

    private JButton startButton;
    private GridBagConstraints c;

    OpeningPanel(JPanel CardLayoutPanel) {
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);

        

        startButton = new JButton("Start");
        startButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("35");

                    CardLayout cl = (CardLayout)(CardLayoutPanel.getLayout());
                    cl.show(CardLayoutPanel, "TheWorkCard");

                    // Start the countdown.
                    WorkPanel.timerOn = true;

                }
            }
        );

        add(startButton, c);


    }






}