import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimPanel extends JPanel implements ActionListener {
    Prostokat prostokat;
    private int delay = 70;

    private Timer timer;
    public AnimPanel(){
        setBackground(Color.WHITE);
        setBounds(7, 11, 422, 219);
        timer = new Timer(delay, this);
        prostokat = new Prostokat();
        timer.addActionListener(prostokat);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
