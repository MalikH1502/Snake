import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JWindow;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Snake Game");
        Game game = new Game();
        window.add(game);
        window.setBackground(Color.GREEN);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        Input restart = new Input();
        window.addKeyListener(restart);
        game.start();
   
}}