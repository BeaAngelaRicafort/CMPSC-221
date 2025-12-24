package java2ddrawingapplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DrawingApplicationFrame extends JFrame
{
    private DrawPanel drawPanel;
    private ArrayList<MyShapes> shapes = new ArrayList<>();
    
    // Create the panels for the top of the application. 
    // One panel for each line, one to contain both of those panels.
    
    private JPanel topPanel = new JPanel(); 
    private JPanel shapePanel = new JPanel();
    private JPanel optionsPanel = new JPanel(); 

    // Create Widgets for firstLine Panel
    
    private JLabel shapeLabel = new JLabel("Shape:");
    
    String shapesList[] = {"Line", "Oval", "Rectangle"};
    private JComboBox shapesComboBox = new JComboBox(shapesList);
    
    private JButton firstColorButton = new JButton("1st Color");
    private JButton secondColorButton = new JButton("2nd Color");
    private JButton undo = new JButton("Undo");
    private JButton clear = new JButton("Clear"); 

    // Create Widgets for secondLine Panel
    
    private JLabel optionsLabel = new JLabel("Options:");
    private JCheckBox filled = new JCheckBox("Filled");
    private JCheckBox gradient = new JCheckBox("Use Gradient"); 
    private JCheckBox dashed = new JCheckBox("Use Dashed");
    
    private JLabel lineWidthLabel = new JLabel("Line Width:");
    private JSpinner lineWidthSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 99, 1));
    
    private JLabel dashLengthLabel = new JLabel("Dash Length:");
    private JSpinner dashLengthSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 99, 1)); 
    
    // Variables for drawPanel
    
    private Point startPoint; 
    private Point endPoint; 
    private Color firstColor;
    private Color secondColor;
    private Paint paint; 
    private boolean fill; 
    private BasicStroke stroke;
    private int lineWidth = (Integer) lineWidthSpinner.getValue();
    private int dashLength = (Integer) dashLengthSpinner.getValue(); 

    // Status Label
    
    private JLabel statusLabel = new JLabel("");
  
    // Constructor for DrawingApplicationFrame

    public DrawingApplicationFrame()
    {
        setTitle("Java 2D Drawings");
        setLayout(new BorderLayout());
        drawPanel = new DrawPanel();

        // Adds Widgets to Panels

        shapePanel.add(shapeLabel); 
        shapePanel.add(shapesComboBox);
        shapePanel.add(firstColorButton);
        shapePanel.add(secondColorButton);
        shapePanel.add(undo);
        shapePanel.add(clear);
        
        optionsPanel.add(optionsLabel);
        optionsPanel.add(filled);
        optionsPanel.add(gradient);
        optionsPanel.add(dashed);
        optionsPanel.add(lineWidthLabel);
        optionsPanel.add(lineWidthSpinner);
        optionsPanel.add(dashLengthLabel);
        optionsPanel.add(dashLengthSpinner);
        
        // Colors
        
        shapePanel.setBackground(Color.CYAN);
        optionsPanel.setBackground(Color.CYAN);
        topPanel.setBackground(Color.CYAN);
        drawPanel.setBackground(Color.WHITE);
        statusLabel.setForeground(Color.LIGHT_GRAY);

        // Adds Top Panel of Two Panels
        
        topPanel.setLayout(new GridLayout (2, 1));
        topPanel.add(shapePanel);
        topPanel.add(optionsPanel);

        // Adds topPanel to North, drawPanel to Center, and statusLabel to South
        
        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        
        // Adds Listeners and Event Handlers
                
        firstColorButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    firstColor = JColorChooser.showDialog(null, "Choose a color", Color.LIGHT_GRAY); 
                }
            }
        );
                
        secondColorButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    secondColor = JColorChooser.showDialog(null, "Choose a color", Color.LIGHT_GRAY); 
                }
            }
        );
        
        undo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!shapes.isEmpty()) {
                        shapes.remove(shapes.size() - 1);
                        drawPanel.repaint(); 
                    }
                }
            }
        );
        
        clear.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    shapes.clear();
                    drawPanel.repaint();
                    }
                }
        );
    }

    // Create Private Inner Class for DrawPanel
    
    private class DrawPanel extends JPanel
    {

        public DrawPanel()
        {
            addMouseListener(new MouseHandler());
            addMouseMotionListener(new MouseHandler());
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Loops, Draws Each Shape in shapes ArrayList
            
            for (MyShapes shape : shapes) {
                shape.draw(g2d); 
            }
        }
        
        private class MouseHandler extends MouseAdapter implements MouseMotionListener
        {

            public void mousePressed(MouseEvent event)
            {
                startPoint = event.getPoint();
                endPoint = event.getPoint();
                String shape = (String) shapesComboBox.getSelectedItem();
                fill = filled.isSelected(); 
                
                if (gradient.isSelected())
                {
                    paint = new GradientPaint(0, 0, firstColor, 50, 50, secondColor, true);
                } else 
                {   
                    paint = firstColor;
                }
                
                if (dashed.isSelected())
                {
                    lineWidth = (Integer) lineWidthSpinner.getValue();
                    
                    dashLength = (Integer) dashLengthSpinner.getValue();
                    float[] dashLengthFloat = {dashLength};
                    
                    stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashLengthFloat, 0); 
                } else
                {
                    stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                }
                
                if (shape.equals("Line")) {
                    shapes.add(new MyLine(startPoint, endPoint, paint, stroke));
                } else if (shape.equals("Oval")) {
                    shapes.add(new MyOval(startPoint, endPoint, paint, stroke, fill));
                } else if (shape.equals("Rectangle")) {
                    shapes.add(new MyRectangle(startPoint, endPoint, paint, stroke, fill));
                }                
            }

            @Override
            public void mouseDragged(MouseEvent event)
            {
                endPoint = event.getPoint();
                (shapes.get(shapes.size() - 1)).setEndPoint(endPoint);
                drawPanel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent event)
            {
                statusLabel.setText("(" + event.getX() + ", " + event.getY() + ")");
            }
        }
    }
}
