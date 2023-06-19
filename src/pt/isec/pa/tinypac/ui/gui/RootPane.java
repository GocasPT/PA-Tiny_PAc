package pt.isec.pa.tinypac.ui.gui;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import pt.isec.pa.tinypac.model.GameManager;
import pt.isec.pa.tinypac.model.data.EDirection;
import pt.isec.pa.tinypac.model.data.GameData;
import pt.isec.pa.tinypac.model.fsm.game.EGameState;
import pt.isec.pa.tinypac.ui.gui.resources.CSSManager;
import pt.isec.pa.tinypac.ui.gui.resources.ImageManager;
import pt.isec.pa.tinypac.ui.gui.uiStates.*;

public class RootPane extends BorderPane {
    private GameManager _gameManager;
    private GameData _gameData;

    public RootPane(GameManager gameManager){
        this._gameManager = gameManager;

        _gameData = new GameData();

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        CSSManager.applyCSS(this, "styles.css");

        StackPane stackPane = new StackPane(
                new MenuUI(_gameManager),
                new PlayingUI(_gameManager),
                new PausedUI(_gameManager),
                new PowerUpUI(_gameManager),
                new WinUI(_gameManager),
                new LoseUI(_gameManager)
        );

        stackPane.setBackground(
                new Background(
                        new BackgroundImage(
                                ImageManager.getImage("background.png"),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                new BackgroundSize(1,1,true,true,true,false)
                        )
                )
        );

        this.setCenter(stackPane);
    }

    private void registerHandlers() { _gameManager.addPropertyChangeListener(evt -> { update(); }); }


    private void update() {}
}
