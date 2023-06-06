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
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;
import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;
import pt.isec.pa.tinypac.model.data.maze.item.*;
import pt.isec.pa.tinypac.model.data.player.Pacman;

import java.io.IOException;

public class TinyPAcTUI implements IGameEngineEvolve {
    private MazeManager _model;
    private Terminal _terminal;
    private Screen _screen;

    //PLACE_HOLDER
    private KeyStroke dir;
    private String str = "Null";
    //PLACE_HOLDER

    public TinyPAcTUI(MazeManager model) throws IOException {
        this._model = model;
        this._terminal = new DefaultTerminalFactory()
                //.setInitialTerminalSize(new TerminalSize(40, 45))
                .setInitialTerminalSize(new TerminalSize(100, 45))
                .createTerminal();
        _terminal.setCursorVisible(false);
        this._screen = new TerminalScreen(_terminal);
        //showMenu();
    }

    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {
        /*
        if(_fsm == null)
            return;
        if(!_maze.evolve())
            gameEngine.stop();
        */
        //saveLogs();
        //showBoard();
    }

    public void showMenu() throws IOException {
        int y;
        _screen.startScreen();
        _screen.clear();

        //TODO opções (jogo, top5, sair)
        Menu: while(true) {
            System.out.println("Menu");

            y = 2;
            _terminal.clearScreen();
            _terminal.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);

            //TODO centralizar texto
            _terminal.setCursorPosition(5, y++);
            _terminal.putString("$$$$$$$$\\ $$\\                           $$$$$$$\\   $$$$$$\\"); _terminal.setCursorPosition(5, y++);;
            _terminal.putString("\\__$$  __|\\__|                          $$  __$$\\ $$  __$$\\"); _terminal.setCursorPosition(5, y++);
            _terminal.putString("   $$ |   $$\\ $$$$$$$\\  $$\\   $$\\       $$ |  $$ |$$ /  $$ | $$$$$$$\\"); _terminal.setCursorPosition(5, y++);
            _terminal.putString("   $$ |   $$ |$$  __$$\\ $$ |  $$ |      $$$$$$$  |$$$$$$$$ |$$  _____|"); _terminal.setCursorPosition(5, y++);
            _terminal.putString("   $$ |   $$ |$$ |  $$ |$$ |  $$ |      $$  ____/ $$  __$$ |$$ /"); _terminal.setCursorPosition(5, y++);
            _terminal.putString("   $$ |   $$ |$$ |  $$ |$$ |  $$ |      $$ |      $$ |  $$ |$$ |"); _terminal.setCursorPosition(5, y++);
            _terminal.putString("   $$ |   $$ |$$ |  $$ |\\$$$$$$$ |      $$ |      $$ |  $$ |\\$$$$$$$\\"); _terminal.setCursorPosition(5, y++);
            _terminal.putString("   \\__|   \\__|\\__|  \\__| \\____$$ |      \\__|      \\__|  \\__| \\_______|"); _terminal.setCursorPosition(5, y++);
            _terminal.putString("                        \\$$$$$$  |"); _terminal.setCursorPosition(5, y++);
            _terminal.putString("                         \\______/");

            y += 3;
            _terminal.setCursorPosition(5, y+=2);
            _terminal.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
            //TODO centralizar texto
            _terminal.putString("1 - Start Game"); _terminal.setCursorPosition(5, y+=2);
            _terminal.putString("2 - Top5"); _terminal.setCursorPosition(5, y+=2);
            _terminal.putString("3 - Sair"); _terminal.setCursorPosition(5, y+=2);

            _terminal.flush();


            KeyStroke input = _screen.readInput();
            if (input.getCharacter() == null) continue;
            switch (input.getCharacter()) {
                case '1':
                    startGame();
                    break;

                case '2':
                    showTop5();
                    break;

                case '3':
                    break Menu;
            }
        }

        _screen.close();
        _terminal.close();
    }

    private void startGame() throws IOException {
        _terminal.clearScreen();
        _screen.clear();
        //TODO: reset do maze fsm state
        //_model.

        //TODO: janela do jogo
        Game: while (true) {
            switch (_model.getMazeState()) {
                case INIT_GAME_STATE -> {
                    _model.loadLevel();

                    showBoard();
                    showDebug();

                    System.out.println("Carrega numa das setas para começar o jogo");
                    dir = _screen.readInput();
                    keyPress : while (true) {
                        switch (dir.getKeyType()) {
                            case ArrowUp, ArrowDown, ArrowRight, ArrowLeft -> {
                                //_fsm.startGame();
                                break keyPress;
                            }

                            case Escape -> {
                                //PLACE_HOLDER
                                break Game;
                            }
                        }
                    }
                }

                case PLAYING_STATE -> {
                    dir = _screen.readInput();
                    keyPress : while (true) {
                        switch (dir.getKeyType()) {
                            case ArrowUp -> {
                                str = "Cima";
                                break keyPress;
                            }

                            case ArrowDown -> {
                                str = "Baixo";
                                break keyPress;
                            }

                            case ArrowRight -> {
                                str = "Direita";
                                break keyPress;
                            }

                            case ArrowLeft -> {
                                str = "Esquerda";
                                break keyPress;
                            }

                            case Escape -> {
                                //_model.pauseGame();
                                //PLACE_HOLDER
                                break Game;
                            }
                        }
                    }
                }

                case PAUSE_STATE -> {
                    _model.pauseGame();
                    //_gameEngine.pause();
                }

                case POWER_UP_STATE -> {
                    //_gameEngine.setInterval(5000);
                }

                case END_GAME_STATE -> {
                    _model.endGame();
                    break Game;
                }
            }

            //PLACE_HOLDER (evolve)
            showBoard();
            showDebug();
        }
    }

    private void showDebug() throws IOException {
        int y = 35;
        _terminal.setBackgroundColor(TextColor.ANSI.BLACK);
        _terminal.setForegroundColor(TextColor.ANSI.GREEN);

        _terminal.setCursorPosition(1, y++);
        _terminal.putString("DEBUG");
        _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Maze State: %s\t\t", _model.getMazeState())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Movement Direction: %s\t\t", str)); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Blinky State: %s\t\t", _model.getBlinkyState())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Pinky State: %s\t\t", _model.getPinkyState())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Inky State: %s\t\t", _model.getInkyState())); _terminal.setCursorPosition(1, y++);
        _terminal.putString(String.format("Clyde State: %s\t\t", _model.getClydeState()));

        _terminal.flush();
    }

    private void showBoard() throws IOException {
        char[][] mazeChars = _model.getMazeBoard();

        for (int y = 0; y < mazeChars.length; y++) {
            for (int x = 0; x < mazeChars[0].length; x++) {
                TextColor tc = switch(mazeChars[y][x]) {
                    case Fruit.SYMBOL -> TextColor.ANSI.RED;
                    case PacDot.RENDER, PacPill.RENDER -> TextColor.ANSI.YELLOW;
                    case Warp.SYMBOL -> TextColor.ANSI.WHITE;
                    case Wall.SYMBOL -> TextColor.ANSI.BLUE;
                    case Pacman.SYMBOL -> TextColor.ANSI.YELLOW_BRIGHT;
                    case GhostCaseDoor.SYMBOL -> TextColor.ANSI.WHITE_BRIGHT;
                    default -> TextColor.ANSI.BLACK;
                };

                TextColor bc = switch(mazeChars[y][x]) {
                    case Wall.SYMBOL -> TextColor.ANSI.BLUE;
                    case GhostCaseDoor.SYMBOL -> TextColor.ANSI.WHITE_BRIGHT;
                    case Pacman.SYMBOL -> TextColor.ANSI.YELLOW_BRIGHT;
                    //case Ghost -> ;
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

        _terminal.putString("Top 5");

        _terminal.setCursorPosition(2, 10);
        _terminal.putString("Press \"Esc\" to exit");
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
    }
}
