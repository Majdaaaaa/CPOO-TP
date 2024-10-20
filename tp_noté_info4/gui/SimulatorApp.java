package gui;

import model.SimulatorModel;

/**
 * Launcher class containing the main method.
 */
public final class SimulatorApp {
    private final TextSpriteFactory factory;
    private final SimulatorModel model;

    public SimulatorApp() {
        this.factory = new TextSpriteFactory();
        this.model = new SimulatorModel(
                3, // lives
                3, // width of the board
                5, // height of the board
                factory);
    }

    private void init() {
        model.init();
        factory.displayAll();
    }

    private void mainLoop() {
        while (model.isActive()) {
            model.update();
            factory.displayAll();
        }
    }

    public static void main(String[] args) {
        var app = new SimulatorApp();
        app.init();
        app.mainLoop();
    }
}