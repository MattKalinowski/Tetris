package com.game.tetris.blocks;

import com.game.tetris.Game;
import com.game.tetris.playfield.Grid;
import com.game.tetris.services.PositionHelper;

import java.awt.*;

public class Square {

    private Grid grid;
    private float positionX, positionY;
    private Color color;

    public Square(Grid grid, float positionX, float positionY, Color color) {
        this.grid = grid;
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;

        grid.addSquare(this);
    }

    public void tick() {
        positionX = PositionHelper.clamp(positionX, 96, Game.PLAYFIELD_WIDTH + 63);
        positionY = PositionHelper.clamp(positionY, 0, Game.PLAYFIELD_HEIGHT);
        //collision1();
        //collision2();
        //collision3();
    }

    private void collision3() {
        for (Square square : grid.getSquares()) {
            if (!square.equals(this)) {

            }
        }
    }

    private void collision2() {
        for (Square square : grid.getSquares()) {
            if (!square.equals(this)) {
                if (Math.abs(square.getPositionX() - positionX) < 32) {
                    if (positionX < square.getPositionX()) {
                        System.out.println("test1");
                        positionX = square.getPositionX() - 32;
                    }
                    if (positionX >= square.getPositionX()) {
                        System.out.println("test2");
                        positionX = square.getPositionX() + 32;
                    }
                }
                if (Math.abs(square.getPositionY() - positionY) < 32) {
                    System.out.println("square.getPositionY() = " + square.getPositionY() + " positionY = " + positionY);
                    if (positionY < square.getPositionY()) {
                        System.out.println("test3");
                        //positionY = square.getPositionY() - 32;
                    }

                }
            }
        }
    }

    private void collision1() {
        for (Square square : grid.getSquares()) {
            if (!square.equals(this) && this.getBounds().intersects(square.getBounds())) {
                if (positionX > square.getPositionX()) {
                    System.out.println("test1");
                    positionX = PositionHelper.clamp(positionX, square.getPositionX() + 33, square.getPositionX() + 33);
                } else if (positionX < square.getPositionX()) {
                    System.out.println("test2");
                    positionX = PositionHelper.clamp(positionX, square.getPositionX() - 33, square.getPositionX() - 33);
                } else if (positionY > square.getPositionY()) {
                    System.out.println("test3");
                    positionY = PositionHelper.clamp(positionY, square.getPositionY() + 33, square.getPositionY() + 33);
                } else if (positionY < square.getPositionY()) {
                    System.out.println("test4");
                    positionY = PositionHelper.clamp(positionY, square.getPositionY() - 33, square.getPositionY() - 33);
                }
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

}
