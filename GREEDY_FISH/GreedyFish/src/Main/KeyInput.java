import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput  implements KeyListener {
    Player p;

    public KeyInput(Player p){
        this.p=p;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
    //รับค่าเมื่อกดปุ่มจากคีย์บอร์ด ของ คลาสPlayer
    @Override
    public void keyPressed(KeyEvent e) {
        p.keyPressed(e);
    }

    //รับค่าเมื่อปล่อยปุ่มจากคีย์บอร์ด ของ คลาสPlayer
    @Override
    public void keyReleased(KeyEvent e) {
        p.keyReleased(e);
    }
}
