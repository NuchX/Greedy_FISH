import java.awt.*;
import java.util.LinkedList;

public class EditEnemy  {
    static LinkedList<Enemy> e = new LinkedList<>();
    static LinkedList<posion> p = new LinkedList<>();
    Enemy temp;
    posion temp2;
    public int coutEnemy = 3 ;
    private int a=0;

    public EditEnemy(){
       for(int i = 0;i<coutEnemy;i++) {
           a=(int)(Math.random()*290);
           addEnemy(new Enemy(a,0));
       }

        for(int i = 0;i<2;i++) {
            a=(int)(Math.random()*290);
            addPosion(new posion(a,0));
        }
    }

    public void responeEnemy(){
        a=(int)(Math.random()*500);
        addEnemy(new Enemy(a,0));
    }

    public void responePosion(){
        a=(int)(Math.random()*500);
        addPosion(new posion(a,0));
    }

    public void draw(Graphics2D g2d){
        for (int i = 0 ; i < e.size();i++){
            temp=e.get(i);
            temp.draw(g2d);
        }

        for (int i = 0 ; i < p.size();i++){
            temp2=p.get(i);
            temp2.draw(g2d);
        }
    }

    public void update(){
        for (int i = 0 ; i < e.size() ; i++){
            temp=e.get(i);
            temp.update();
        }

        for (int i = 0 ; i < p.size() ; i++){
            temp2=p.get(i);
            temp2.update();
        }
    }


    public void addEnemy(Enemy enemy){
        e.add(enemy);
    }
    public void addPosion(posion posion){
        p.add(posion);
    }


    public static LinkedList<Enemy> getEnemyBound(){
        return e;
    }
    public static LinkedList<posion> getPosionBound(){
        return p;
    }

}
