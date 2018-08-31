package com.game.tetris.keyboard;

import com.game.tetris.Handler;
import com.game.tetris.blocks.Block;
import com.game.tetris.blocks.I;
import com.game.tetris.blocks.Square;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (Block block : handler.getBlocks()) {
            if (block instanceof I) { // if controlled by player
                if (key == KeyEvent.VK_UP) {
                    block.rotate();
                }
                if (key == KeyEvent.VK_LEFT) {
                    for (Square square : block.getSquares()) {
                        square.setPositionX(square.getPositionX() - 32);
                    }
                }
                if (key == KeyEvent.VK_RIGHT) {
                    for (Square square : block.getSquares()) {
                        square.setPositionX(square.getPositionX() + 32);
                    }
                }
            }
        }
    }

    private boolean overlaps(Square comparedSquare, LinkedList<Square> squares, int distance) {
        for (Square square : squares) {
            if (comparedSquare.getPositionX() + distance == comparedSquare.getPositionX()) return true;
        }
        return false;
    }
}
