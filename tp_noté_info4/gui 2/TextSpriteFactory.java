package gui;

import java.util.ArrayList;
import java.util.List;

import model.Sprite;
import model.SpriteFactory;

/**
 * Concrete factory for text sprites, implementing the abstract factory from the
 * simulator model.
 */
public final class TextSpriteFactory implements SpriteFactory {
    private final List<TextSprite> instances = new ArrayList<>();

    @Override
    public Sprite make(String name, int x, int y) {
        var widget = new TextSprite(name, x, y, instances::remove);
        instances.add(widget);
        return widget;
    }

    public void displayAll() {
        for (var w : instances)
            w.display();
    }

}
