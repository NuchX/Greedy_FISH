import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//เป็นคลาสที่ควบคุมแกมทั้งหมด
public class Gamepanel extends JPanel implements ActionListener {
    Timer loop;
    Player player;
    EditEnemy editEnemy;
    public int Time = 0;//ใช้กำหนดเวลาในการเล่นเกม
    boolean Check = false;//ตรวจเช็ดว่าเกมทำงานหรือไม่
    String BG = "GreedyFish/src/Main/photo/bg sea.gif";

    public Gamepanel() {
        loop = new Timer(10, this);
        player = new Player(100, 100);
        editEnemy = new EditEnemy();
        addKeyListener(new KeyInput(player));
        setFocusable(true);
    }

    //วาดObjective ต่างๆของเกม และ ควบคุมการเล่นของเกม
    @Override
    public void paint(Graphics g) {
        var bchar = new ImageIcon(BG);
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.drawImage(bchar.getImage(), 0, 0, null);
        g2d.setFont(new Font("Tahama", Font.BOLD, 20));
        g2d.drawString("Time = " + Time, 400, 30);
        player.draw(g2d);
        if (Check == true){
            editEnemy.draw(g2d);
            
        }

        //รับค่าจากเมาส์เปลี่ยนค่า Check ให้เป็น True เพื่อทำให้เกมเล่นได้
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(Check = true)
                Time = 1000 ;
                loop.start();
                player.restart();
            }
        });
    }

    //ใช้อัพเดทค่าต่างๆภายในเกม
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        editEnemy.update();
        Time--;

        //เมื่อเวลาหมดเกมจะหยุดทันที
        if (Time <= 0) {
            loop.stop();
            Check = false;
            repaint();
        }

        player.newscore();
        repaint();
    }
}
