package pt.isec.pa.tinypac.ui.gui.uiStates;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import pt.isec.pa.tinypac.model.GameManager;

public class PausedUI extends BorderPane {
    private GameManager _gameManager;
    private Button _btnResume, _btnExit;

    public PausedUI(GameManager gameManager) {
        _gameManager = gameManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        this.setCenter(hBox);
    }

    private void registerHandlers() {
        _gameManager.addPropertyChangeListener(evt -> { update(); });
    }

    private void update() {
        if (_gameManager.getMazeState() == null) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

    }
}
