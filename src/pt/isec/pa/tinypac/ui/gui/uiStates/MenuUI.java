package pt.isec.pa.tinypac.ui.gui.uiStates;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pt.isec.pa.tinypac.model.GameManager;
import pt.isec.pa.tinypac.ui.gui.resources.ImageManager;

public class MenuUI extends BorderPane {
    private GameManager _gameManager;
    private ImageView _imgLogo;
    private Button _btnStart, _btnTop5, _btnExit;

    public MenuUI(GameManager gameManager) {
        _gameManager = gameManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        _imgLogo = new ImageView(ImageManager.getImage("title.png"));
        _btnStart = new Button("Start");
        _btnTop5 = new Button("Top5");
        _btnExit  = new Button("Exit");

        VBox vBox = new VBox(_imgLogo, _btnStart, _btnTop5, _btnExit);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        this.setCenter(vBox);
    }

    private void registerHandlers() {
        _gameManager.addPropertyChangeListener(evt -> { update(); });

        _btnStart.setOnAction( event -> {
            _gameManager.initGame();
        });

        _btnTop5.setOnAction( event -> {
            _gameManager.loadTop5();
        });

        _btnExit.setOnAction( event -> {
            Platform.exit();
        });
    }

    private void update() {
        if (_gameManager.getMazeState() != null) {
            this.setVisible(false);
            return;
        }

        this.setVisible(true);
    }
}
