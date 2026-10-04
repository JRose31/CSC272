import javax.swing.*;

public class CircleDrawingGUI {

    public CircleDrawingGUI() {

        JFrame frame = new JFrame(
                "Circle Drawing Program"
        );

        DrawingPanel drawingPanel = new DrawingPanel();

        frame.add(
                drawingPanel
        );

        frame.setSize(
                700,
                500
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setVisible(true);
    }
}