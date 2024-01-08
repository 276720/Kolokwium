import javax.swing.*;
import java.awt.*;

public class AnimatorApp extends JFrame {
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    final AnimatorApp frame = new AnimatorApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public AnimatorApp(){
        setTitle("Aplikacja");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        AnimPanel kanwa = new AnimPanel();
        contentPane.add(kanwa);

        setSize(450,300);
        setBackground(Color.WHITE);
        setVisible(true);
    }
}
