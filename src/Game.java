import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
    int originalSize = 64;
    int maxRows = 16;
    int maxCols = 12;
    int screenWidth = originalSize * maxRows;
    int screenHeight = originalSize * maxCols;

    int fps = 60;

    int playerSize = 32;
    int playerx = 150;
    int playery = 100;
    int playerspeed = 5;

    Input inputh = new Input();
    Thread gameTime;

    public Game(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GREEN);
        this.addKeyListener(inputh);
        this.setFocusable(true);
    }

    public void start(){
        gameTime = new Thread(this);
        gameTime.start();
    }
    @Override
    public void run() {
        double fpsInterval = 1000 / fps;
        double nextFrameTime = System.currentTimeMillis() + fpsInterval;
        if (gameTime == null && inputh.RPressed == true){
            gameTime = new Thread(this);
            gameTime.start();
            playerx = 150;
            playery = 100;
        }
        while (gameTime != null){
            
            update();
            repaint();
            double remainingTime = nextFrameTime - System.currentTimeMillis();
            try {
                Thread.sleep((long)remainingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextFrameTime = System.currentTimeMillis() + fpsInterval;
        }
    }
    public void update(){
        if (inputh.WPressed == true){
            playery -= playerspeed;
            System.out.println("W Pressed");
        }
        if (inputh.SPressed == true){
            playery += playerspeed;
        }
        if (inputh.APressed == true){
            playerx -= playerspeed;
        }
        if (inputh.DPressed == true){
            playerx += playerspeed;
        }
        if (playerx <0 || playerx > screenWidth - 64 || playery < 0 || playery > screenHeight - 64){
            gameTime = null;
            
        }
        
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(playerx, playery, originalSize, originalSize);
        g2d.dispose();
        }
    }

