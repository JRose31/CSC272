import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {

    // Store multiple circles
    private ArrayList<Circle> circles;

    public DrawingPanel() {

        circles = new ArrayList<>();

        setBackground(
                Color.LIGHT_GRAY
        );

        // Manages user interactions with panel (captures and stores input)
        addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            MouseEvent event
                    ) {

                        int x = event.getX();
                        int y = event.getY();

                        String radiusInput = JOptionPane.showInputDialog(
                                DrawingPanel.this,
                                "Enter the radius:"
                        );

                        int radius = Integer.parseInt(
                                radiusInput
                        );

                        // Create new circle and persist
                        Circle circle = new Circle(
                                x,
                                y,
                                radius
                        );

                        circles.add(circle);

                        repaint();

                        System.out.println(
                                "Center: " + x + ", " + y + " Radius: " + radius
                        );
                    }
                }
        );

    }

    // Generate graphic for rendering circle
    @Override
    protected void paintComponent(
            Graphics g
    ) {

        super.paintComponent(g);

        // Iterate through circle arrays to display all
        for (Circle circle : circles) {

            int x =
                    circle.getCenterX();

            int y =
                    circle.getCenterY();

            int radius =
                    circle.getRadius();

            int drawX =
                    x - radius;

            int drawY =
                    y - radius;

            int diameter =
                    radius * 2;

            // Draw circle
            g.drawOval(
                    drawX,
                    drawY,
                    diameter,
                    diameter
            );
        }
    }

}