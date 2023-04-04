import javax.swing.*;
import java.awt.*;

public class Enemy {
    private int x=-5,y=-5;
    private int speedy=3;

    public Enemy(int x,int y){
        this.x=x;
        this.y=y;
    }

    //วาดตัวอาหารขึ้นมา
    public void draw(Graphics2D g2d){
        var imagae="GreedyFish/src/Main/photo/cookie.gif";
        var bchar = new ImageIcon(imagae);
        g2d.setColor(Color.BLUE);
        g2d.drawImage(bchar.getImage(),x, y,null);
    }

    //อัพเดทค่าต่างๆในคลาสEnemy
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

    // กำหนดขอบเขต
    public Rectangle getBounds(){
        return new Rectangle(x,y,22,22);
    }
}
