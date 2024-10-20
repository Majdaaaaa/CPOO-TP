package gui;

import java.util.function.Consumer;

import model.Sprite;

/**
 * Sprite implementation using text standard output as display.
 */
public final class TextSprite implements Sprite {
    // Widget coordinates
    private int x, y;
    // Widget name
    private final String name;
    // Widget uncommitted coordinates
    private int nextX, nextY;

    private final Consumer<TextSprite> destroy;

    public TextSprite(String name, int x, int y, Consumer<TextSprite> destroy) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.nextX = x;
        this.nextY = y;
        this.destroy = destroy;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        // do not store uncommitted values directly in the main attributes
        this.nextX = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        // do not store uncommitted values directly in the main attributes
        this.nextY = y;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Called by the model when the new values are ready to be displayed.
     */
    @Override
    public void commit() {
        x = nextX;
        y = nextY;
    }

    /**
     * This sprite implemetation needs this additional method to display the sprite as text in standard output.
     */
    public void display() {
        System.out.printf("%s : je suis en (%d, %d).\n", name, x, y);
    }

    /**
     * Called by the model when the sprite is not needed anymore and thus should not be dispayed anymore.
     */
    @Override
    public void destroy() {
        this.destroy.accept(this);
    }
    
}
