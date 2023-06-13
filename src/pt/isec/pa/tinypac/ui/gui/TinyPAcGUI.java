package pt.isec.pa.tinypac.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.tinypac.Main;
import pt.isec.pa.tinypac.gameengine.GameEngine;
import pt.isec.pa.tinypac.model.GameManager;

public class TinyPAcGUI extends Application {
    private GameManager _gameManager;
    private GameEngine _gameEngine = new GameEngine();

    @Override
    public void init() throws Exception {
        super.init();
        _gameManager = Main.gameManager;

        _gameEngine.registerClient(_gameManager);


        //_gameEngine.start(200);
    }

    @Override
    public void start(Stage stage) throws Exception {
        newStageForTesting(stage, "TinyPac");
    }

    private void newStageForTesting(Stage stage, String title) {
        RootPane root = new RootPane(_gameManager);
        Scene scene = new Scene(root, 800, 516);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.resizableProperty().set(false);
        stage.show();
    }
}
