package model;

public class SimulatorModel {

    private int lives;
    private int width;
    private int height;
    private SpriteFactory factory;
    private Sprite currentSprite;
    int aux=1;
    int life;

    public SimulatorModel(int l, int w, int h, SpriteFactory f) {
        this.lives = l;
        this.width = w;
        this.height = h;
        this.factory = f;
        life=l;
    }

    public void init() {
        createNewSprite();
    }

    public boolean isActive() {
        return this.lives > 0;
    }

    public void update() {
        if (currentSprite != null) {
            currentSprite.setX(currentSprite.getX() + 1);
            currentSprite.setY(currentSprite.getY() + 1);
            currentSprite.commit();

            if (currentSprite.getX() >= width || currentSprite.getY() >= height) {
                currentSprite.destroy();
                lives--;
                aux++;
                if (lives > 0) {
                    createNewSprite();
                }
            }
        }
    }

    private void createNewSprite() {
        currentSprite = factory.make("Numéro " + aux  + "/" + life, 0, 0);
    }
}
