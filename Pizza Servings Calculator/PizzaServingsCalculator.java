package pizzaservingscalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaServingsCalculator extends JFrame implements ActionListener {

    JFrame frame = new JFrame("Pizza Servings Calculator"); // Sets Up Frame
    
    private final JLabel title; // Grid Slot 1: Title 
    
    // Grid Slot 2: Prompt, Text Input
    private JPanel line2; // Panel (2 Items in 1 Grid Slot) 
    private final JLabel prompt;
    private final JTextField size;
    
    private final JButton calculate; // Grid Slot 3: Button
    
    private final JLabel display; // Grid Slot 4: Output
    
    public PizzaServingsCalculator() {

        frame.setSize(350, 300); // Sets Frame Size
        frame.setLayout(new GridLayout (4, 1)); // Sets Grid Layout
        
        // Grid Slot 1: Title 
        title = new JLabel("Pizza Servings Calculator", SwingConstants.CENTER);
        title.setForeground(Color.RED);
        
        frame.add(title); // Adds to Grid Slot 1
        
        // Grid Slot 2: Prompt, Text Input 
        prompt = new JLabel("Enter the size of the pizza in inches: ");
        size = new JTextField(4);
        
        // Sets Up Panel (2 Items in 1 Grid Slot)
        line2 = new JPanel();
        line2.add(prompt);
        line2.add(size);
        
        frame.add(line2); // Adds to Grid Slot 2
        
        // Grid Slot 3: Button 
        calculate = new JButton("Calculate Servings");
        calculate.addActionListener(this); // If Pressed
        
        frame.add(calculate); // Adds to Grid Slot 3
        
        // Grid Slot 4: Output
        display = new JLabel("", SwingConstants.CENTER);  
        
        frame.add(display); // Adds to Grid Slot 4
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame Close Operation
        frame.setVisible(true); // Sets Frame Visible
    }
    
    @Override
    public void actionPerformed(ActionEvent calculate) {

        double pizzaSize = Double.parseDouble(size.getText()); // Retrieves Size from Text Input
        double servings = Math.pow((pizzaSize / 8), 2); // Calculates Servings
        display.setText(String.format("A %.0f inch pizza will serve %.2f people.", pizzaSize, servings)); // Output Text

    }
    
    public static void main(String [] args) {

        PizzaServingsCalculator calculator = new PizzaServingsCalculator();

    }

}
