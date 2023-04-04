import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Player {
    private int x= 100;
    private int y = 100;
    private int speedx=0;
    private int speedy=0;
    private int score= 0;
    private int newscore= 0;
    EditEnemy editEnemy;
    public String playerimgae ="GreedyFish/src/Main/photo/FishRight.gif";
    private LinkedList<Enemy>e=EditEnemy.getEnemyBound();
    private LinkedList<posion> p=EditEnemy.getPosionBound();

    public Player(int x,int y){
        this.x=100;
        this.y=100;
        this.score=score;
        this.newscore=newscore;
        editEnemy=new EditEnemy();
    }

    // นับแต้มHight score
    public void newscore(){
        if(score>newscore){
            newscore=score;
        }
    }

    //อัพเดทค่าต่างๆในคลาสPlayer
    public void update(){
        y+=speedy;
        x+=speedx;
        if(x<0){
            x=0;
        }
        if(y<0){
            y=0;
        }
        if(x>470){
            x=470;
        }
        if(y>440){
            y=440;}

        colision();
    }

    //วาดตัวPlayer
    public void draw(Graphics2D g2d){
        var bchar = new ImageIcon(playerimgae);
        g2d.drawImage(bchar.getImage(),x, y,null);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Tahama",Font.BOLD,20));
        g2d.drawString("High Score = "+this.newscore,0,40);
        g2d.drawString("Score = "+this.score,0,20);
    }

    //เซตค่าใหม่
    public void restart(){
        score=0;
        x=100;
        y=100;
    }

    //รับค่าจากคีย์บอร์ด และทำการเครื่อนที่
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP){
            speedy=-7;
        }
        if (key == KeyEvent.VK_DOWN){
            speedy=7;
        }
        if(key== KeyEvent.VK_RIGHT){
            speedx=7;
            playerimgae="GreedyFish/src/Main/photo/FishRight.gif";
        }
        if (key == KeyEvent.VK_LEFT){
            speedx=-7;
            playerimgae="GreedyFish/src/Main/photo/FishLeft.gif";
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP){
            speedy=0;
        }
        if (key == KeyEvent.VK_DOWN){
            speedy=0;
        }
        if(key == KeyEvent.VK_RIGHT){
            speedx=0;
        }
        if (key == KeyEvent.VK_LEFT){
            speedx=0;
        }
    }

    //กำหนดขอบเขต
    public Rectangle getBounds(){
        return new Rectangle(x,y,60,32);
    }


    public void colision(){
        //ตรวจสอบการชน
        for (int i = 0 ; i < e.size();i++){
            if(getBounds().intersects(e.get(i).getBounds())){
                e.remove(i);
                score+=1;
                editEnemy.responeEnemy();
            }
        }
        for (int i = 0 ; i < p.size();i++){
            if(getBounds().intersects(p.get(i).getBounds())){
                p.remove(i);
                score-=5;
                editEnemy.responePosion();
                playerimgae = "GreedyFish/src/Main/photo/poisfish.gif";
            }
        }
    }
}
