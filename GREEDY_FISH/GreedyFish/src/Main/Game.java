import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame("Greedy Fish");
        window.setSize(540,500);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new Gamepanel());
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
