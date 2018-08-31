package com.game.tetris;

import com.game.tetris.blocks.Block;
import com.game.tetris.blocks.I;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private LinkedList<Block> blocks = new LinkedList<>();

    private int interval = 50;

    public void tick() {
        for (Block block : blocks) {
            interval -= 1;
            if (interval == 0) {
                block.tick();
                interval = 50;
            }
        }
    }

    public void render(Graphics g) {
        for (Block block : blocks) {
            block.render(g);
        }
    }
    public void addBlock(Block block){
        this.blocks.add(block);
    }
    public void removeBlock(Block block){
        this.blocks.remove(block);
    }

    public LinkedList<Block> getBlocks() {
        return blocks;
    }
}
