package pt.isec.pa.tinypac.ui.text;

//  import lanterna package
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TerminalSize;

//  import tinypac package
import pt.isec.pa.tinypac.Main;
import pt.isec.pa.tinypac.gameengine.GameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;
import pt.isec.pa.tinypac.model.GameManager;
import pt.isec.pa.tinypac.model.data.maze.item.*;
import pt.isec.pa.tinypac.model.data.player.*;
import pt.isec.pa.tinypac.model.data.ghost.*;
import pt.isec.pa.tinypac.model.fsm.game.EGameState;

import java.io.IOException;

public class TinyPAcTUI implements IGameEngineEvolve {
    private final GameManager _gameManager;
    //private GameEngine _gameEngine = new GameEngine();
    private final Terminal _terminal;
    private final Screen _screen;
    private final int _terminalCenterCollumn;
    private boolean _debugOn;


    public TinyPAcTUI() throws IOException {
        _gameManager = Main.gameManager;

        //_gameEngine.registerClient(_gameManager);

        _terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(100, 45))
                .createTerminal();
        _screen = new TerminalScreen(_terminal);
        _terminalCenterCollumn = _terminal.getTerminalSize().getColumns();
        //PLACE_HOLDER
        _debugOn = true;
    }

    //TODO: envolve para mostrar o tabuleiro em tempo real
    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {
        /*if(_fsm == null)
            return;
        if(!_maze.evolve())
            gameEngine.stop();

        showBoard();
        if (_debugOn) showDebug();*/
        try {
            if (_gameManager.getMazeContext() == null)
                return;

            if (_gameManager.getMazeState() == EGameState.INIT_GAME_STATE ) {
                gameEngine.stop();
                //PLACE_HOLDER
                //showMenu();
                showMenu(gameEngine);
                return;
            }

            showBoard();
            if (_debugOn) showDebug();

        } catch (IOException e) { }
    }

    //public void showMenu() throws IOException {
    public void showMenu(IGameEngine gameEngine) throws IOException {
        int y;
        _screen.startScreen();
        _screen.clear();

        Menu: while(true) {
            y = 2;
            _terminal.clearScreen();
            _terminal.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);
            _terminal.setBackgroundColor(TextColor.ANSI.BLACK);

            _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("$$$$$$$$\\ $$\\                           $$$$$$$\\   $$$$$$\\"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);;
            _terminal.putString("\\__$$  __|\\__|                          $$  __$$\\ $$  __$$\\"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("   $$ |   $$\\ $$$$$$$\\  $$\\   $$\\       $$ |  $$ |$$ /  $$ | $$$$$$$\\"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("   $$ |   $$ |$$  __$$\\ $$ |  $$ |      $$$$$$$  |$$$$$$$$ |$$  _____|"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("   $$ |   $$ |$$ |  $$ |$$ |  $$ |      $$  ____/ $$  __$$ |$$ /"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("   $$ |   $$ |$$ |  $$ |$$ |  $$ |      $$ |      $$ |  $$ |$$ |"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("   $$ |   $$ |$$ |  $$ |\\$$$$$$$ |      $$ |      $$ |  $$ |\\$$$$$$$\\"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("   \\__|   \\__|\\__|  \\__| \\____$$ |      \\__|      \\__|  \\__| \\_______|"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("                        \\$$$$$$  |"); _terminal.setCursorPosition((_terminalCenterCollumn - 70) / 2, y++);
            _terminal.putString("                         \\______/");

            String[] menu = {
                    "1 - New Game",
                    "2 - Load Game",
                    "3 - Top5",
                    "4 - Exit"
            };
            y += 3;
            _terminal.setCursorPosition((_terminalCenterCollumn - menu[0].length()) / 2, y+=2);
            _terminal.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);

            _terminal.putString(menu[0]); _terminal.setCursorPosition((_terminalCenterCollumn - menu[1].length()) / 2, y+=2);

            //TODO: check if exist file game
            /*
            if () {
                _terminal.setForegroundColor(TextColor.ANSI.RED);
            }
             */

            _terminal.putString(menu[1]); _terminal.setCursorPosition((_terminalCenterCollumn - menu[2].length()) / 2, y+=2);

            //_terminal.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);

            _terminal.putString(menu[2]); _terminal.setCursorPosition((_terminalCenterCollumn - menu[3].length()) / 2, y+=2);
            _terminal.putString(menu[3]);

            if (_debugOn) {
                _terminal.setCursorPosition( 2, _terminal.getTerminalSize().getRows() - 2);
                _terminal.setForegroundColor(TextColor.ANSI.GREEN);
                _terminal.putString("Debug on");
            }

            _terminal.setCursorVisible(false);
            _terminal.flush();

            KeyStroke input = _screen.readInput();
            if (input.getCharacter() == null) continue;
            switch (input.getCharacter()) {
                case '1':
                    startGame(gameEngine);
                    break;

                case '2':
                    loadGame();
                    break;

                case '3':
                    showTop5();
                    break;

                case '4':
                    break Menu;

                //Debug mode
                case '0':
                    _debugOn = !_debugOn;
                    break;
            }
        }

        _screen.close();
        _terminal.close();
    }

    //private void startGame() throws IOException {
    private void startGame(IGameEngine gameEngine) throws IOException {
        KeyStroke input;
        _terminal.clearScreen();
        _screen.clear();

        //TODO: reset do state
        _gameManager.resetFSM();
        _gameManager.setDirection(EPacmanDirection.NONE);

        //TODO: janela do jogo
        Game: while (true) {
            switch (_gameManager.getMazeState()) {
                case INIT_GAME_STATE -> {
                    _gameManager.loadLevel();

                    showBoard();

                    if (_debugOn) showDebug();

                    //TODO: por isto no terminal em vez na consola do IDE
                    System.out.println("Carrega numa das setas para começar o jogo");
                    input = _screen.readInput();
                    keyPress : while (true) {
                        switch (input.getKeyType()) {
                            //TODO: verficar esta parte
                            case ArrowUp, ArrowDown, ArrowRight, ArrowLeft -> {
                                gameEngine.start(200);
                                _gameManager.startGame(input.getKeyType());

                                switch (input.getKeyType()) {
                                    case ArrowUp ->  _gameManager.setDirection(EPacmanDirection.UP);
                                    case ArrowDown -> _gameManager.setDirection(EPacmanDirection.DOWN);
                                    case ArrowRight -> _gameManager.setDirection(EPacmanDirection.RIGHT);
                                    case ArrowLeft -> _gameManager.setDirection(EPacmanDirection.LEFT);
                                }
                                break keyPress;
                            }

                            //TODO: check se seria ainda o Esc como butão de saida neste caso
                            case Escape -> {
                                //PLACE_HOLDER
                                break Game;
                            }
                        }
                    }
                }

                case PLAYING_STATE -> {
                    input = _screen.readInput();
                    keyPress : while (true) {
                        switch (input.getKeyType()) {
                            case ArrowUp -> {
                                _gameManager.setDirection(EPacmanDirection.UP);
                                break keyPress;
                            }

                            case ArrowDown -> {
                                _gameManager.setDirection(EPacmanDirection.DOWN);
                                break keyPress;
                            }

                            case ArrowRight -> {
                                _gameManager.setDirection(EPacmanDirection.RIGHT);
                                break keyPress;
                            }

                            case ArrowLeft -> {
                                _gameManager.setDirection(EPacmanDirection.LEFT);
                                break keyPress;
                            }

                            //TODO: Esc = pausa
                            case Escape -> {
                                //_gameManager.pauseGame();
                                //PLACE_HOLDER
                                gameEngine.stop();
                                break Game;
                            }
                        }
                    }
                }

                //TODO: verificar esta parte
                case PAUSE_STATE -> {
                    _gameManager.pauseGame();
                    //_gameEngine.pause();

                    input = _screen.readInput();
                    switch (input.getKeyType()) {
                        //TODO: verificar esta parte
                        case Escape -> {
                            //_gameManager.resume();
                        }

                        case Enter -> {
                            _gameManager.setDirection(EPacmanDirection.NONE);
                            break Game;
                        }
                    }
                }

                //TODO: verficar esta parte
                case POWER_UP_STATE -> {
                    //_gameEngine.setInterval(5000);
                }

                case END_GAME_STATE -> {
                    _gameManager.endGame();
                    showEndScree();
                    break Game;
                }
            }

            //PLACE_HOLDER (evolve)
            showBoard();
            if (_debugOn) showDebug();
        }
    }

    //TODO: função para carregar jogo
    private void loadGame() {

    }

    private void showDebug() throws IOException {
        int y = 35;
        _terminal.setBackgroundColor(TextColor.ANSI.BLACK);
        _terminal.setForegroundColor(TextColor.ANSI.GREEN);
        EPacmanDirection dir = _gameManager.getDirection();
        String dirStr = null;

        if (dir != null) {
            switch (dir) {
                case UP -> dirStr = "Cima";
                case DOWN -> dirStr = "Baixo";
                case LEFT -> dirStr = "Esquerda";
                case RIGHT -> dirStr = "Direita";
                case NONE -> dirStr = "Parado";
            }
        }

        _terminal.setCursorPosition(1, y++);
        _terminal.putString("DEBUG");
        _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Maze State: %s\t\t", _gameManager.getMazeState())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Maze level: %d", _gameManager.getNumLevel())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Movement Direction: %s\t\t", dirStr)); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Blinky State: %s\t\t", _gameManager.getBlinkyState())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Pinky State: %s\t\t", _gameManager.getPinkyState())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Inky State: %s\t\t", _gameManager.getInkyState())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Clyde State: %s\t\t", _gameManager.getClydeState()));

        _terminal.setCursorVisible(false);
        _terminal.flush();
    }

    private void showBoard() throws IOException {
        char[][] mazeChars = _gameManager.getMaze();

        for (int y = 0; y < mazeChars.length; y++) {
            for (int x = 0; x < mazeChars[0].length; x++) {
                TextColor tc = switch(mazeChars[y][x]) {
                    case Fruit.SYMBOL -> TextColor.ANSI.RED;
                    case PacDot.RENDER, PacPill.RENDER, Pacman.SYMBOL -> TextColor.ANSI.YELLOW_BRIGHT;
                    case Warp.SYMBOL -> TextColor.ANSI.WHITE;
                    case Wall.SYMBOL -> TextColor.ANSI.BLUE;
                    case GhostCaseDoor.SYMBOL -> TextColor.ANSI.WHITE_BRIGHT;
                    case Blinky.SYMBOL -> TextColor.ANSI.RED_BRIGHT;
                    case Pinky.SYMBOL -> TextColor.ANSI.MAGENTA_BRIGHT;
                    case Inky.SYMBOL -> TextColor.ANSI.BLUE_BRIGHT;
                    case Clyde.SYMBOL -> TextColor.ANSI.YELLOW;
                    default -> TextColor.ANSI.BLACK;
                };

                TextColor bc = switch(mazeChars[y][x]) {
                    case Wall.SYMBOL -> TextColor.ANSI.BLUE;
                    case GhostCaseDoor.SYMBOL -> TextColor.ANSI.WHITE_BRIGHT;
                    case Pacman.SYMBOL -> TextColor.ANSI.YELLOW_BRIGHT;
                    case Blinky.SYMBOL -> TextColor.ANSI.RED_BRIGHT;
                    case Pinky.SYMBOL -> TextColor.ANSI.MAGENTA_BRIGHT;
                    case Inky.SYMBOL -> TextColor.ANSI.BLUE_BRIGHT;
                    case Clyde.SYMBOL -> TextColor.ANSI.YELLOW;
                    default -> TextColor.ANSI.BLACK;
                };

                _screen.setCharacter(x+5,y+2, TextCharacter.fromCharacter(mazeChars[y][x],tc,bc)[0]);
            }
        }

        _screen.refresh();
    }

    private void showTop5() throws IOException {
        _terminal.clearScreen();
        _screen.clear();

        //TODO: top5
        _terminal.setCursorPosition(2, 5);

        //TODO: centralizar texto
        _terminal.putString("Top 5");

        //TODO: ler ficheiro dos top5 e mostrar

        _terminal.setCursorPosition(2, 10);
        _terminal.putString("Press \"Esc\" to exit");
        _terminal.setCursorVisible(false);
        _terminal.flush();

        while (true) {
            KeyStroke input = _screen.readInput();
            if (input.getKeyType() == KeyType.Escape) {
                break;
            }
        }
    }

    private void showEndScree() throws IOException {
        _terminal.clearScreen();
        _screen.clear();

        //TODO: win or lose screen + input para ir ao menu

        _terminal.setCursorVisible(false);
        _terminal.flush();

        //showMenu();
    }
}
