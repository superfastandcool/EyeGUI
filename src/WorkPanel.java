package src;
// import java.awt.GridBagConstraints;
// import java.awt.GridBagLayout;
// import java.awt.Insets;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import javax.swing.JButton;
// import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;


public class WorkPanel extends JPanel{

    private JButton goBackButton;
    private GridBagConstraints c;
    private JTextField timeDisplay;

    private Timer checkTimer;                   // Used to check if to start the timer for the countdown.
    
    private Timer secondlyTimer;                // Creates an event every second. This "timer" is used to display the countdown.
    private long startTime;                     // The time the countdown started.
    // private final long workDuration = 10000;    // Duration of the countdown.
    private final long workDuration = 1200000;

    public static Boolean timerOn = false;
    private Boolean timerAlreadyStarted = false;

    WorkPanel(JPanel CardLayoutPanel) {
        setLayout(new GridBagLayout());


        /* Add "Go back" button. */
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 10, 10);

        

        goBackButton = new JButton("Go back");
        goBackButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Go back.");

                    CardLayout cl = (CardLayout)(CardLayoutPanel.getLayout());
                    cl.show(CardLayoutPanel, "TheOpeningCard");

                    timerAlreadyStarted = false;
                    timerOn = false;


                    // Stop the countdown.
                    secondlyTimer.stop();
                    timerOn = false;
                    timerAlreadyStarted = false;
                    timeDisplay.setText("");
                }
            }
        );

        add(goBackButton, c);

        

        /* Check if the timer for the countdown should be started.*/
        checkTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timerOn == true && timerAlreadyStarted == false) {
                    // Start the timer.
                    secondlyTimer.start();
                    startTime = System.currentTimeMillis();

                    // Set as true.
                    timerAlreadyStarted = true;
                }
            }
        });

        checkTimer.start();




        /* Add time display. */
        timeDisplay = new JTextField();
        timeDisplay.setText("");
        timeDisplay.setEditable(false);


        
        secondlyTimer = new Timer(1000, new ActionListener() {


            
            @Override
            public void actionPerformed(ActionEvent e) {

                
                long now = System.currentTimeMillis();
                long clockTime = now - startTime;


                // If countdown has ended.
                if (clockTime >= workDuration) {
                    clockTime = workDuration;
                    
                    // Stop the timer.
                    secondlyTimer.stop();

                    // Play music.
                    System.out.println("Break.");
                }


                // Display the time display.
                SimpleDateFormat df = new SimpleDateFormat("mm:ss");
                timeDisplay.setText(df.format(workDuration - clockTime));
                if (df.format(workDuration - clockTime).equals("19:59")) {
                    System.out.println("128");
                }

            }
            
        });

        secondlyTimer.setInitialDelay(0);







        // Position of time display.
        c.fill = GridBagConstraints.HORIZONTAL;
        // c.ipady = 50; // Increase the minimum height by 50 pixels.
        // c.ipadx = 50;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 0, 0);

        timeDisplay.setHorizontalAlignment(JTextField.CENTER);
        timeDisplay.setFont(new Font("Ariel", Font.BOLD, 25));

        
        add(timeDisplay, c);

    }






}