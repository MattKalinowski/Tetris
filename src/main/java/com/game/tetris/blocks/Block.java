package com.game.tetris.blocks;

import com.game.tetris.Handler;

import java.awt.*;
import java.util.LinkedList;

public abstract class Block {

    private Handler handler;

    private Orientation orientation = Orientation.HORIZONTAL;

    public Block(Handler handler) {
        this.handler = handler;
    }

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

    protected abstract void setOrientation(Orientation orientation);

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public abstract LinkedList<Square> getSquares();

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
