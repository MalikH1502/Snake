package main;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import sprites.snakeplay;

public class Game extends JPanel implements Runnable{
    public int originalSize = 64;
    int maxRows = 16;
    int maxCols = 12;
   public int screenWidth = originalSize * maxRows;
   public int screenHeight = originalSize * maxCols;

    int fps = 60;


    int playerSize = 32;
    int playerx = 150;
    int playery = 100;
    int playerspeed = 5;

    public Input inputh = new Input();
   public Thread gameTime;
    snakeplay snake = new snakeplay(this, inputh);

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
            if (remainingTime > 0) {
                try {
                    Thread.sleep((long) remainingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            nextFrameTime = System.currentTimeMillis() + fpsInterval;
        }
    }
    public void update(){
        snake.update();
        
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        snake.draw(g2d);
       
        g2d.dispose();
        }
    }

