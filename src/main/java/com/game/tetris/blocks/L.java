package com.game.tetris.blocks;

import com.game.tetris.Handler;

import java.awt.*;
import java.util.LinkedList;

public class L extends Block {

    public L(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
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
    protected void setOrientation(Orientation orientation) {

    }
}
