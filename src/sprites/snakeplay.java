package sprites;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Game; 
import main.Input;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class snakeplay extends apple {
    BufferedImage snake, snakeBody, snakeEnd;
    int x;
    int y;
    int speed;
    Game game;
    Input input;
    Thread gametime;
    public snakeplay(Game game, Input input) {
        this.game = game;
        this.input = input;
        setDef();
        getSnakeImage();
    }
    public void setDef(){
         x = 150;
         y = 100;
         speed = 7;
    }
    public void getSnakeImage(){

        try {
            snake = ImageIO.read(new File("src/player/snakeHead.png"));
            snakeBody = ImageIO.read(new File("src/player/snakeBody.png"));
            snakeEnd = ImageIO.read(new File("src/player/snakeEnd.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        if (game.inputh.WPressed == true){
            y -= speed;
        }
        if (input.SPressed == true){
            y += speed;
        }
        if (input.APressed == true){
            x -= speed;
        }
        if (input.DPressed == true){
            x += speed;
        }
        if (x <0 || x > game.screenWidth - 64 || y < 0 || y > game.screenHeight - 64){
            gametime = null;
            
        }
    }
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x, y, game.originalSize, game.originalSize);
    }
    
}
