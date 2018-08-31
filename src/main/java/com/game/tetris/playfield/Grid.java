package com.game.tetris.playfield;

import com.game.tetris.Game;
import com.game.tetris.blocks.Square;

import java.awt.*;
import java.util.LinkedList;

public class Grid {
    private LinkedList<Square> squares = new LinkedList<>();

    public void tick() {
        for (Square square : squares) {
            square.tick();
        }
    }

    public void render(Graphics g) {
        drawHorizontalLines(g);
        drawVerticalLines(g);
    }

    private void drawHorizontalLines(Graphics g) {
        int y = 32;
        for (int i = 0; i < 20; i++) {
            g.setColor(Color.DARK_GRAY);
            g.drawLine(96, y, Game.PLAYFIELD_WIDTH + 96, y);
            y += 32;
        }
    }

    private void drawVerticalLines(Graphics g) {
        int x = 96;
        for (int i = 0; i < 10; i++) {
            g.setColor(Color.DARK_GRAY);
            g.drawLine(x, 32, x, Game.PLAYFIELD_HEIGHT + 32);
            x += 32;
        }
    }

    public void addSquare(Square square){
        squares.add(square);
    }
    public void removeSquare(Square square){
        squares.remove(square);
    }

    public void addSquares(LinkedList<Square> squares){
        squares.addAll(squares);
    }
    public void removeSquare(LinkedList<Square> squares){
        squares.removeAll(squares);
    }

    public LinkedList<Square> getSquares() {
        return squares;
    }
}
