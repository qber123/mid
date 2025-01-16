import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        final boolean[] turn = {true};
        // Create the main frame
        JFrame frame = new JFrame("3x3 Button Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Create a panel with a GridLayout (3x3)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3)); // 3 rows, 3 columns

        JButton[][] buttons = new JButton[3][3];

        boolean[][] permits = new boolean[3][3];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                AtomicBoolean did = new AtomicBoolean(false);
                permits[i][j] = false;
                buttons[i][j] = new JButton();
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener(e -> {
                    if (turn[0] && !permits[finalI][finalJ]){
                        buttons[finalI][finalJ].setText("X");
                        turn[0] = !turn[0];
                        permits[finalI][finalJ] = true;
                        did.set(true);
                    } else if (!turn[0] && !permits[finalI][finalJ]){
                        buttons[finalI][finalJ].setText("O");
                        turn[0] = !turn[0];
                        permits[finalI][finalJ] = true;
                        did.set(true);
                    }

                    for(int rows = 0; rows < 3; rows++){
                        if (Objects.equals(buttons[rows][0].getText(), buttons[rows][1].getText()) && Objects.equals(buttons[rows][1].getText(), buttons[rows][2].getText())){
                            if (Objects.equals(buttons[rows][0].getText(), "X") || Objects.equals(buttons[rows][0].getText(), "O")){
                                System.out.println(buttons[rows][0].getText() + " win");
                                JOptionPane.showMessageDialog(null, buttons[rows][0].getText() + " win", "Info", JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);
                            }

                        }
                    }

                    for(int columns = 0; columns < 3; columns++){
                        if (Objects.equals(buttons[0][columns].getText(), buttons[1][columns].getText()) && Objects.equals(buttons[1][columns].getText(), buttons[2][columns].getText())){
                            if (Objects.equals(buttons[0][columns].getText(), "X") || Objects.equals(buttons[0][columns].getText(), "O")){
                                System.out.println(buttons[0][columns].getText() + " win");
                                JOptionPane.showMessageDialog(null, buttons[0][columns].getText() + " win", "Info", JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);
                            }
                        }
                    }

                    if (Objects.equals(buttons[0][0].getText(), buttons[1][1].getText()) && Objects.equals(buttons[1][1].getText(), buttons[2][2].getText())){
                        if (Objects.equals(buttons[1][1].getText(), "X") || Objects.equals(buttons[1][1].getText(), "O")){
                            System.out.println(buttons[1][1].getText() + " win");
                            JOptionPane.showMessageDialog(null, buttons[1][1].getText() + " win", "Info", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                    }

                    if (Objects.equals(buttons[2][0].getText(), buttons[1][1].getText()) && Objects.equals(buttons[1][1].getText(), buttons[0][2].getText())){
                        if (Objects.equals(buttons[1][1].getText(), "X") || Objects.equals(buttons[1][1].getText(), "O")){
                            System.out.println(buttons[1][1].getText() + " win");
                            JOptionPane.showMessageDialog(null, buttons[1][1].getText() + " win", "Info", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                    }

                });
                panel.add(buttons[i][j]);
            }
        }


        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
