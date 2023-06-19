package pt.isec.pa.tinypac;

import javafx.application.Application;
import pt.isec.pa.tinypac.gameengine.GameEngine;
import pt.isec.pa.tinypac.model.GameManager;
import pt.isec.pa.tinypac.ui.gui.TinyPAcGUI;
import pt.isec.pa.tinypac.ui.text.TinyPAcTUI;

import java.io.IOException;;

public class Main {
    public static GameManager gameManager;
    static {
        gameManager = new GameManager();
    }

    public static void main(String[] args) throws IOException {
        /*TinyPAcTUI ui = new TinyPAcTUI();
        GameEngine gameEngine = new GameEngine();
        gameEngine.registerClient(gameManager);
        gameEngine.registerClient(ui);
        ui.showMenu(gameEngine);*/

        Application.launch(TinyPAcGUI.class, args);
    }
}