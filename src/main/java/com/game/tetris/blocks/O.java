package com.game.tetris.blocks;

import com.game.tetris.Handler;

import java.awt.*;
import java.util.LinkedList;

public class O extends Block {

    public O(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public LinkedList<Square> getSquares() {
        return null;
    }

    @Override
    public void rotate() {

    }
}
