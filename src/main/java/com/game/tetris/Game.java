package com.game.tetris;

import com.game.tetris.blocks.I;
import com.game.tetris.keyboard.KeyInput;
import com.game.tetris.playfield.Grid;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int SCREEN_WIDTH = 512, SCREEN_HEIGHT = 704;
    public static final int PLAYFIELD_WIDTH = 320, PLAYFIELD_HEIGHT = 608;

    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private Grid grid;
    //private HUD hud;

    public Game() {
        handler = new Handler();
        grid = new Grid();
        this.addKeyListener(new KeyInput(handler));
        new Window(SCREEN_WIDTH, SCREEN_HEIGHT, "TETRIS", this);

        //hud = new HUD();

        handler.addBlock(new I(handler, grid));
    }

    private void tick() {
        handler.tick();
        grid.tick();
        //hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        g.setColor(Color.GRAY);
        g.fillRect(96, 32, PLAYFIELD_WIDTH, PLAYFIELD_HEIGHT);
        grid.render(g);
        handler.render(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0, SCREEN_WIDTH, 32); // black stripe covers new blocks on the top of the window
        //hud.render(g);
        g.dispose();
        bs.show();
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
