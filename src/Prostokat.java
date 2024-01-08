import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Prostokat  implements Runnable, ActionListener {

    private int startX, startY, endX, endY, width, height, x, y;
    private int delay = 70;
    private Component component;
    protected Area area;
    protected Shape shape;
    protected AffineTransform aft;
    private Point initialPosition;
    public Prostokat(){
        aft = new AffineTransform();
        area = new Area(shape);

        this.component = component;
        setDrawing();
    }
    public void setDrawing(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
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
        //initialPosition = ;
        aft.translate(initialPosition.getX(), initialPosition.getY());
        area.transform(aft);
        shape = area;
        while (true) {
            shape = nextFrame();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }
    public Shape nextFrame(){
        area = new Area(area);
        aft = new AffineTransform();
        Rectangle bounds = area.getBounds();
        int cx = bounds.x + bounds.width / 2;
        int cy = bounds.y + bounds.height / 2;
        if (cx > width){
            cx = (int) initialPosition.getX() + bounds.width / 2;
            cy = (int) initialPosition.getY() + bounds.height / 2;
            area = new Area(new Rectangle(cx - bounds.width / 2, cy - bounds.height / 2, bounds.width, bounds.height));
        }
        aft.translate(cx, cy);
        aft.translate(-cx, -cy);

        area.transform(aft);
        return area;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
