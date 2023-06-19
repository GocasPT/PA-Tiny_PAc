package pt.isec.pa.tinypac.ui.gui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pt.isec.pa.tinypac.model.GameManager;

public class Top5UI extends BorderPane  {
    private GameManager _gameManager;

    public Top5UI(GameManager gameManager) {
        _gameManager = gameManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        this.setCenter(vBox);
    }

    private void registerHandlers() {
        _gameManager.addPropertyChangeListener(evt -> { update(); });


    }

    private void update() {
        if (_gameManager.getMazeState() != null) {
            this.setVisible(false);
            return;
        }

        this.setVisible(true);

    }
}
