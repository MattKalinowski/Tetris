package com.game.tetris.playfield;

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
