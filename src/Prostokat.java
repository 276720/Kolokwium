import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Prostokat  implements Runnable{
    private int startX, startY, endX, endY, width, height, x, y;
    private Component component;
    public Prostokat(){
        this.component = component;
        setDrawing();
    }
    public void setDrawing(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //super.mouseReleased(e);
                endX = e.getX();
                endY = e.getY();

                width = Math.abs(endX - startX);
                height = Math.abs(endY - startY);

                x = Math.min(startX, endX);
                y = Math.min(startY, endY);

                new Thread(() -> {
                    Graphics g = component.getGraphics();
                    g.drawRect(x, y, width, height);
                }).start();
            }
        });
    }

    @Override
    public void run() {

    }
}
