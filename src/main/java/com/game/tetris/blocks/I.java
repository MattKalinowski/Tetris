package com.game.tetris.blocks;

import com.game.tetris.Handler;
import com.game.tetris.playfield.Grid;

import java.awt.*;
import java.util.LinkedList;

public class I extends Block {

    private LinkedList<Square> squares = new LinkedList<>();

    public I(Handler handler, Grid grid) {
        super(handler);
        //Color color = Color.CYAN;
        squares.add(new Square(grid, 192, 256, Color.CYAN));
        squares.add(new Square(grid, 224, 256, Color.BLUE));
        squares.add(new Square(grid, 256, 256, Color.RED));
        squares.add(new Square(grid, 288, 256, Color.PINK));
    }

    @Override
    public void tick() {
        dropBlock();
    }

    private void dropBlock() {
        for (Square square : squares) {
            square.setPositionY(square.getPositionY()); // + 32
        }
    }

    @Override
    public void render(Graphics g) {
        for (Square square : squares) {
            square.render(g);
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public LinkedList<Square> getSquares() {
        return squares;
    }

    @Override
    protected void setOrientation(Orientation orientation) {
        int right = 1;
        int left = -1;

        if (orientation == Orientation.HORIZONTAL) {
            setHorizontal(right);
        }
        if (orientation == Orientation.VERTICAL) {
            setVertical(right);
        }
        if (orientation == Orientation.HORIZONTAL_LEFT) {
            setHorizontal(left);
        }
        if (orientation == Orientation.VERTICAL_LEFT) {
            setVertical(left);
        }
    }

    private void setVertical(int direction) {
        squares.get(0).setPositionX(squares.get(0).getPositionX() + (64 * direction));
        squares.get(0).setPositionY(squares.get(0).getPositionY() - (64 * direction));

        squares.get(1).setPositionX(squares.get(1).getPositionX() + (32 * direction));
        squares.get(1).setPositionY(squares.get(1).getPositionY() - (32 * direction));

        squares.get(3).setPositionX(squares.get(3).getPositionX() - (32 * direction));
        squares.get(3).setPositionY(squares.get(3).getPositionY() + (32 * direction));
    }

    private void setHorizontal(int direction) {
        squares.get(0).setPositionX(squares.get(0).getPositionX() - (32 * direction));
        squares.get(0).setPositionY(squares.get(0).getPositionY() - (32 * direction));

        squares.get(2).setPositionX(squares.get(2).getPositionX() + (32 * direction));
        squares.get(2).setPositionY(squares.get(2).getPositionY() + (32 * direction));

        squares.get(3).setPositionX(squares.get(3).getPositionX() + (64 * direction));
        squares.get(3).setPositionY(squares.get(3).getPositionY() + (64 * direction));
    }

}
