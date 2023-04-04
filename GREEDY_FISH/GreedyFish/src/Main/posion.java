import javax.swing.*;
import java.awt.*;

public class posion {
    private int x,y;
    private int speedy=3;

    public posion(int x,int y){
        this.x=x;
        this.y=y;
    }

    //วาดยาพิษ
    public void draw(Graphics2D g2d){
        var imagae="GreedyFish/src/Main/photo/posion.gif";
        var bchar = new ImageIcon(imagae);
        g2d.drawImage(bchar.getImage(),x, y,null);
    }

    //อัพเดทค่าต่างๆในคลาสPosion
    public void update(){
        y+=speedy;
        if(y>440){
            y=0;
            x=(int)(Math.random()*500);
        }
        if (y<0){
            speedy=3;
        }
    }

    //กำหนดขอบเขต
    public Rectangle getBounds(){
        return new Rectangle(x,y,22,22);
    }
}