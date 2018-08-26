package com.game.tetris.blocks;

import com.game.tetris.Game;
import com.game.tetris.playfield.Grid;
import com.game.tetris.services.PositionHelper;

import java.awt.*;

public class Square {

    private Grid grid;
    private float positionX, positionY;
    private float velocityX, velocityY;
    private Color color;

    public Square(Grid grid, float positionX, float positionY, Color color) {
        this.grid = grid;
        this.positionX = positionX;
        this.positionY = positionY;
        //this.velocityY = 1; // 32
        this.color = color;

        grid.addSquare(this);
    }

    public void tick() {
        collision();
    }

    private void collision() {
        for (Square square : grid.getSquares()) {
            if (!square.equals(this) && this.getBounds().intersects(square.getBounds())) {
                if (positionX > square.getPositionX()) {
                    System.out.println("test1");
                    positionX = PositionHelper.clamp(positionX, positionX + 1, positionX + 1);
                } else if (positionX < square.getPositionX()) {
                    System.out.println("test2");
                    positionX = PositionHelper.clamp(positionX, positionX - 1, positionX - 1);
                } else if (positionY > square.getPositionY()) {
                    System.out.println("test3");
                    positionY = PositionHelper.clamp(positionY, positionY + 1, positionY + 1);
                } else if (positionY < square.getPositionY()) {
                    System.out.println("test4");
                    positionY = PositionHelper.clamp(positionY, positionY - 1, positionY - 1);
                }
            } else if (positionX > Game.PLAYFIELD_WIDTH + 63 || positionX <= 96) {
                positionX = PositionHelper.clamp(positionX, 96, Game.PLAYFIELD_WIDTH + 63);
            } else if (positionY > Game.PLAYFIELD_HEIGHT - 1) {
                positionY = PositionHelper.clamp(positionY, 0, Game.PLAYFIELD_HEIGHT - 1);
            } else {
                setVelocityY(1);
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) positionX, (int) positionY, 32, 32);
        g.setColor(Color.WHITE);
        g.drawRect((int) positionX, (int) positionY, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) positionX, (int) positionY, 32, 32);
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
}
