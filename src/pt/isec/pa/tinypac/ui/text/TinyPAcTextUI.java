package pt.isec.pa.tinypac.ui.text;

//  import lanterna package
import com.googlecode.lanterna.input.KeyStroke;
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
import pt.isec.pa.tinypac.model.data.maze.item.*;
import pt.isec.pa.tinypac.model.data.player.Pacman;
import pt.isec.pa.tinypac.model.fsm.maze.EMazeState;
import pt.isec.pa.tinypac.model.fsm.maze.MazeContext;

import java.io.IOException;

public class TinyPAcTextUI implements IGameEngineEvolve {
    private MazeContext _fsm;
    private Terminal _terminal;
    private Screen _screen;

    public TinyPAcTextUI(MazeContext fsm) throws IOException {
        this._fsm = fsm;
        this._terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(40, 40))
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
    }

    private void showDebug() throws IOException {
        _terminal.setCursorPosition(1, 35);
        _terminal.putString("Debuge");
        _terminal.setCursorPosition(1 , 37);
        _terminal.putString("Maze State: "+_fsm.getState());

        _terminal.flush();
    }

    private void showBoard() throws IOException {
        char[][] mazeChars = _fsm.getMazeBoard();
        _screen.startScreen();

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

    public void startGame() throws IOException {
        boolean _finish = false;

        //TODO: janela do jogo
        while (!_finish) {
            switch (_fsm.getState()) {
                case INIT_GAME_STATE -> {
                    _fsm.loadLevel();

                    showDebug();
                    showBoard();

                    System.out.println("Carrega numa das setas para começar o jogo");
                    KeyStroke key = _screen.readInput();
                    keyPress : while (true) {
                        switch (key.getKeyType()) {
                            /*case ArrowUp, ArrowDown, ArrowRight, ArrowLeft -> {
                                _fsm.startGame();
                                break keyPress;
                            }*/
                            case ArrowUp -> {
                                break keyPress;
                            }

                            case ArrowDown -> {
                                break keyPress;
                            }

                            case ArrowRight -> {
                                break keyPress;
                            }

                            case ArrowLeft -> {
                                break keyPress;
                            }
                        }
                    }

                    _fsm.startGame();
                }

                case PLAYING_STATE -> {
                    KeyStroke key = _screen.readInput();
                    keyPress : while (true) {
                        switch (key.getKeyType()) {
                            case ArrowUp -> {
                                System.out.println("Cima");
                            }

                            case ArrowDown -> {
                                System.out.println("Baixo");
                            }

                            case ArrowRight -> {
                                System.out.println("Direita");
                            }

                            case ArrowLeft -> {
                                System.out.println("ESquerda");
                            }

                            default -> {
                                char c = key.getCharacter();
                                switch (c){
                                    case 'p' -> {
                                        _fsm.pauseGame();
                                        break keyPress;
                                    }

                                    case 's' -> {

                                    }
                                }

                            }
                        }
                    }
                }

                case PAUSE_STATE -> {
                    _fsm.pauseGame();
                    //_gameEngine.pause();
                }

                case POWER_UP_STATE -> {
                    //_gameEngine.setInterval(5000);
                }

                case WIN_STATE -> {
                    _finish = true;
                    showEndScree(EMazeState.WIN_STATE);
                }

                case LOSE_STATE -> {
                    showEndScree(EMazeState.LOSE_STATE);
                    _finish = true;
                }
            }

            showDebug();
            showBoard();
        }
    }

    private void showMenu() throws IOException {
        //_screenMenu.startScreen();

        _terminal.putString("$$$$$$$$\\ $$\\                           $$$$$$$\\   $$$$$$\\");_terminal.putCharacter('\n');
        _terminal.putString("\\__$$  __|\\__|                          $$  __$$\\ $$  __$$\\");_terminal.putCharacter('\n');
        _terminal.putString("   $$ |   $$\\ $$$$$$$\\  $$\\   $$\\       $$ |  $$ |$$ /  $$ | $$$$$$$\\");_terminal.putCharacter('\n');
        _terminal.putString("   $$ |   $$ |$$  __$$\\ $$ |  $$ |      $$$$$$$  |$$$$$$$$ |$$  _____|");_terminal.putCharacter('\n');
        _terminal.putString("   $$ |   $$ |$$ |  $$ |$$ |  $$ |      $$  ____/ $$  __$$ |$$ /");_terminal.putCharacter('\n');
        _terminal.putString("   $$ |   $$ |$$ |  $$ |$$ |  $$ |      $$ |      $$ |  $$ |$$ |");_terminal.putCharacter('\n');
        _terminal.putString("   $$ |   $$ |$$ |  $$ |\\$$$$$$$ |      $$ |      $$ |  $$ |\\$$$$$$$\\");_terminal.putCharacter('\n');
        _terminal.putString("   \\__|   \\__|\\__|  \\__| \\____$$ |      \\__|      \\__|  \\__| \\_______|");_terminal.putCharacter('\n');
        _terminal.putString("                        \\$$$$$$  |");_terminal.putCharacter('\n');
        _terminal.putString("                         \\______/");_terminal.putCharacter('\n');
        _terminal.flush();

        //_screenMenu.refresh();
    }

    private void showTop5() throws IOException {
        System.out.println("Top5");
    }

    private void showEndScree(EMazeState type) throws IOException {
        switch (type) {
            case WIN_STATE -> {
                System.out.println("Win");
            }
            case LOSE_STATE -> {
                System.out.println("Lose");
            }
        }
    }
}
