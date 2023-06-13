package pt.isec.pa.tinypac.model;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import javafx.scene.input.KeyCode;
import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.item.*;
import pt.isec.pa.tinypac.model.data.player.EPacmanDirection;
import pt.isec.pa.tinypac.model.data.player.Pacman;
import pt.isec.pa.tinypac.model.fsm.ghost.EGhostState;
import pt.isec.pa.tinypac.model.fsm.game.EGameState;
import pt.isec.pa.tinypac.model.fsm.game.IGameState;
import pt.isec.pa.tinypac.model.fsm.game.GameContext;

import java.io.*;
import java.util.List;

public class GameManager implements IGameEngineEvolve {
    private static final String TOP5_FILE = "files/Top5.txt";
    private GameContext _fsm;

    //TODO: criar FSM  só quando o jogo é para prepara [fora disto fica a null]
    public GameManager() {
        //TODO: verificar esta parte [cria-se a maquina de estados logo ou vamos só construir quando o jogo é iniciado/criado?]
        _fsm = new GameContext();
    }

    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {
        if (_fsm == null)
            return;

        _fsm.evolve();
    }

    // Lanterna
    public void startGame(KeyType key) {
        _fsm.pressKey(key);
    }

    // JavaFX
    public void startGame(KeyCode key) {
        _fsm.pressKey(key);
    }

    public void pauseGame() {
        _fsm.pause();
    }

    public void endGame() {
        //_fsm.quit();
    }

    public void resetFSM() { _fsm.resetFSM(); }
    public void loadLevel() { _fsm.loadLevel(); }

    public char[][] getMaze() { return _fsm.getMaze(); }
    public int getNumLevel() { return _fsm.getNumLevel(); }
    public GameContext getMazeContext() { return _fsm; }
    public EGameState getMazeState() { return _fsm.getState(); }
    public EGhostState getBlinkyState() { return _fsm.getBlinkyState(); }
    public EGhostState getPinkyState() { return _fsm.getPinkyState(); }
    public EGhostState getInkyState() { return _fsm.getInkyState(); }
    public EGhostState getClydeState() { return _fsm.getClydeState(); }
    public EPacmanDirection getDirection() { return _fsm.getDirection(); }

    //TODO: função reset do state, setDirect, etc
    public void setMazeState(IGameState state) { _fsm.changeState(state); }
    public void setDirection(EPacmanDirection dir) { _fsm.setDirection(dir);  }
}
