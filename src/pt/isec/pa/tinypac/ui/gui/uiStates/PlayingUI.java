package pt.isec.pa.tinypac.ui.gui.uiStates;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pt.isec.pa.tinypac.model.GameManager;
import pt.isec.pa.tinypac.model.data.EDirection;
import pt.isec.pa.tinypac.model.data.ghost.Blinky;
import pt.isec.pa.tinypac.model.data.ghost.Clyde;
import pt.isec.pa.tinypac.model.data.ghost.Inky;
import pt.isec.pa.tinypac.model.data.ghost.Pinky;
import pt.isec.pa.tinypac.model.data.maze.item.*;
import pt.isec.pa.tinypac.model.data.player.Pacman;
import pt.isec.pa.tinypac.model.fsm.game.EGameState;
import pt.isec.pa.tinypac.model.fsm.ghost.EGhostState;
import pt.isec.pa.tinypac.ui.gui.resources.ImageManager;

public class PlayingUI extends BorderPane {
    private GameManager _gameManager;
    private GridPane _gdMaze, _gdLifes;
    private Label _lbLevel, _lbPoints, _lbLifes;

    public PlayingUI(GameManager gameManager) {
        _gameManager = gameManager;

        createViews();
        registerHandlers();
        update();
        setFocusTraversable(true);
        requestFocus();
    }

    private void createViews() {
        _lbLevel = new Label("Level: 0");
        _lbPoints = new Label("Points: 0");
        _lbLifes = new Label("Lifes: ");
        _gdLifes = new GridPane();
        _gdMaze = new GridPane();
        _gdMaze.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(_lbLevel, _lbPoints);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(10);

        HBox hBox2 = new HBox(_lbLifes, _gdLifes);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(10);

        VBox vBox = new VBox(hBox1, _gdMaze, hBox2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        this.setCenter(vBox);
    }

    private void registerHandlers() {
        _gameManager.addPropertyChangeListener(evt -> { update(); });

        setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();

            if (_gameManager.getMazeState() == null) return;

            switch (keyCode) {
                case UP -> {
                    _gameManager.setDirection(EDirection.UP);
                    if (_gameManager.getMazeState() == EGameState.INIT_GAME_STATE) {
                        _gameManager.startGame();
                    }
                }
                case DOWN -> {
                    _gameManager.setDirection(EDirection.DOWN);
                    if (_gameManager.getMazeState() == EGameState.INIT_GAME_STATE) {
                        _gameManager.startGame();
                    }
                }
                case LEFT -> {
                    _gameManager.setDirection(EDirection.LEFT);
                    if (_gameManager.getMazeState() == EGameState.INIT_GAME_STATE) {
                        _gameManager.startGame();
                    }
                }
                case RIGHT -> {
                    _gameManager.setDirection(EDirection.RIGHT);
                    if (_gameManager.getMazeState() == EGameState.INIT_GAME_STATE) {
                        _gameManager.startGame();
                    }
                }
            }
        });
    }

    private void update() {
        if (_gameManager.getMazeState() == EGameState.END_GAME_STATE || _gameManager.getMazeState() == null) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

        _gdLifes.getChildren().clear();
         for (int i = 0; i < _gameManager.getVidas(); i++)
             _gdLifes.addColumn(i, new ImageView(ImageManager.getImage("pacman.png")));

        _gdMaze.getChildren().clear();
        char[][] mazeChars = _gameManager.getMaze();

        for (int y = 0; y < mazeChars.length; y++) {
            for (int x = 0; x < mazeChars[0].length; x++) {
                ImageView iv = switch(mazeChars[y][x]) {
                    case Fruit.SYMBOL -> new ImageView(ImageManager.getImage("tile_fruit.png"));
                    case PacDot.RENDER -> new ImageView(ImageManager.getImage("tile_pac_dot.png"));
                    case PacPill.RENDER -> new ImageView(ImageManager.getImage("tile_pac_pill.png"));
                    case Pacman.SYMBOL -> new ImageView(ImageManager.getImage("pacman.png"));
                    case Wall.SYMBOL -> new ImageView(ImageManager.getImage("tile_wall.png"));

                    case Blinky.SYMBOL -> {
                        if (_gameManager.getBlinkyState() == EGhostState.VULNERABLE_STATE)
                            yield new ImageView(ImageManager.getImage("ghost_vulnerable.png"));
                        else
                            yield new ImageView(ImageManager.getImage("ghost_blinky.png"));
                    }

                    case Pinky.SYMBOL -> {
                        if (_gameManager.getPinkyState() == EGhostState.VULNERABLE_STATE)
                            yield new ImageView(ImageManager.getImage("ghost_vulnerable.png"));
                        else
                            yield new ImageView(ImageManager.getImage("ghost_pinky.png"));
                    }

                    case Inky.SYMBOL -> {
                        if (_gameManager.getInkyState() == EGhostState.VULNERABLE_STATE)
                            yield new ImageView(ImageManager.getImage("ghost_vulnerable.png"));
                        else
                            yield new ImageView(ImageManager.getImage("ghost_inky.png"));
                    }

                    case Clyde.SYMBOL -> {
                        if (_gameManager.getClydeState() == EGhostState.VULNERABLE_STATE)
                            yield new ImageView(ImageManager.getImage("ghost_vulnerable.png"));
                        else
                            yield new ImageView(ImageManager.getImage("ghost_clyde.png"));
                    }

                    default -> new ImageView(ImageManager.getImage("tile_black.png"));
                };

                _gdMaze.add(iv, x, y);
            }
        }
    }
}
