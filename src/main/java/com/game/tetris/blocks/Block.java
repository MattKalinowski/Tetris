package com.game.tetris.blocks;

import com.game.tetris.Handler;

import java.awt.*;
import java.util.LinkedList;

public abstract class Block {

    private Handler handler;

    public Block(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public abstract LinkedList<Square> getSquares();

    public abstract void rotate();

}
