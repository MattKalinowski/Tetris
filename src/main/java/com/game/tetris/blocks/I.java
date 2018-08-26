package com.game.tetris.blocks;

import com.game.tetris.Handler;
import com.game.tetris.playfield.Grid;

import java.awt.*;
import java.util.LinkedList;

public class I extends Block {

    private LinkedList<Square> squares = new LinkedList<>();
    private Orientation orientation = Orientation.HORIZONTAL;

    public I(Handler handler, Grid grid) {
        super(handler);
        Color color = Color.CYAN;
        squares.add(new Square(grid, 172, -32, color));
        squares.add(new Square(grid, 204, -32, color));
        squares.add(new Square(grid, 236, -32, color));
        squares.add(new Square(grid, 268, -32, color));
    }

    @Override
    public void tick() {
        for (Square square : squares) {
            square.setPositionX(square.getPositionX() + square.getVelocityX());
            square.setPositionY(square.getPositionY() + square.getVelocityY());
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
    public void rotate() {
        switch (orientation) {
            case HORIZONTAL:
                orientation = Orientation.VERTICAL;
                setOrientation(Orientation.VERTICAL);
                break;
            case VERTICAL:
                orientation = Orientation.HORIZONTAL_LEFT;
                setOrientation(Orientation.HORIZONTAL_LEFT);
                break;
            case HORIZONTAL_LEFT:
                orientation = Orientation.VERTICAL_LEFT;
                setOrientation(Orientation.VERTICAL_LEFT);
                break;
            case VERTICAL_LEFT:
                orientation = Orientation.HORIZONTAL;
                setOrientation(Orientation.HORIZONTAL);
                break;
        }
    }

    private void setOrientation(Orientation orientation) {
        if (orientation == Orientation.VERTICAL) {
            float rotationAxisX = squares.get(2).getPositionX();
            float rotationAxisY = squares.get(2).getPositionY();

            squares.get(0).setPositionX(rotationAxisX);
            squares.get(0).setPositionY(rotationAxisY - 64);

            squares.get(1).setPositionX(rotationAxisX);
            squares.get(1).setPositionY(rotationAxisY - 32);

            squares.get(3).setPositionX(rotationAxisX);
            squares.get(3).setPositionY(rotationAxisY + 32);

        }
        if (orientation == Orientation.HORIZONTAL_LEFT) {
            float rotationAxisX = squares.get(1).getPositionX();
            float rotationAxisY = squares.get(1).getPositionY();

            squares.get(0).setPositionX(rotationAxisX - 64);
            squares.get(0).setPositionY(rotationAxisY);

            squares.get(1).setPositionX(rotationAxisX - 32);
            squares.get(1).setPositionY(rotationAxisY);

            squares.get(2).setPositionY(rotationAxisY);

            squares.get(3).setPositionX(rotationAxisX + 32);
            squares.get(3).setPositionY(rotationAxisY);

        }
        if (orientation == Orientation.VERTICAL_LEFT) {
            float rotationAxisX = squares.get(1).getPositionX();
            float rotationAxisY = squares.get(1).getPositionY();

            squares.get(0).setPositionX(rotationAxisX);
            squares.get(0).setPositionY(rotationAxisY + 64);

            squares.get(2).setPositionX(rotationAxisX);
            squares.get(2).setPositionY(rotationAxisY + 32);

            squares.get(3).setPositionX(rotationAxisX);
            squares.get(3).setPositionY(rotationAxisY - 32);

        }
        if (orientation == Orientation.HORIZONTAL) {
            float rotationAxisX = squares.get(2).getPositionX();
            float rotationAxisY = squares.get(2).getPositionY();

            squares.get(0).setPositionX(rotationAxisX - 32);
            squares.get(0).setPositionY(rotationAxisY);

            squares.get(1).setPositionY(rotationAxisY);

            squares.get(2).setPositionX(rotationAxisX + 32);
            squares.get(2).setPositionY(rotationAxisY);

            squares.get(3).setPositionX(rotationAxisX + 64);
            squares.get(3).setPositionY(rotationAxisY);
        }
    }
}
