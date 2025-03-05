import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {
    public boolean WPressed, SPressed, APressed, DPressed, RPressed;

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            WPressed = true;
            SPressed = false;
            APressed = false;
            DPressed = false;
            RPressed = false;
        }
        if (key == KeyEvent.VK_S) {
            SPressed = true;
            WPressed = false;
            APressed = false;
            DPressed = false;
            RPressed = false;
        }
        if (key == KeyEvent.VK_A) {
            APressed = true;
            WPressed = false;
            SPressed = false;
            DPressed = false;
            RPressed = false;
        
        }
        if (key == KeyEvent.VK_D) {
            DPressed = true;
            WPressed = false;
            SPressed = false;
            APressed = false;
            RPressed = false;
        }
        if (key == KeyEvent.VK_R) {
            RPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            RPressed = false;
        }
    }
}