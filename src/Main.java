import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger();
        // Create JFrame
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("buton.png");
        frame.setIconImage(icon.getImage());
        // Create components
        JButton button = new JButton("Click Me");
        JLabel label = new JLabel(String.valueOf(a.get()), SwingConstants.CENTER);

        // Add event listener
        button.addActionListener((ActionEvent e) -> label.setText(String.valueOf(a.get())));
        button.addActionListener((ActionEvent e) -> a.getAndIncrement());

        // Add components to frame
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
