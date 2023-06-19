package pt.isec.pa.tinypac.model;

import com.googlecode.lanterna.input.KeyType;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;

import pt.isec.pa.tinypac.model.data.EDirection;
import pt.isec.pa.tinypac.model.fsm.ghost.EGhostState;
import pt.isec.pa.tinypac.model.fsm.game.EGameState;
import pt.isec.pa.tinypac.model.fsm.game.IGameState;
import pt.isec.pa.tinypac.model.fsm.game.GameContext;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameManager implements IGameEngineEvolve {
    private static final String TOP5_FILE = "files/Top5.txt";
    private GameContext _fsm;
    private PropertyChangeSupport _pcs;

    public GameManager() {
        _pcs = new PropertyChangeSupport(this);
        _fsm = null;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) { _pcs.addPropertyChangeListener(listener); }

    public void initGame() {
        _fsm = new GameContext();
        _pcs.firePropertyChange(null, null, null);
    }

    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {
        if (_fsm == null) return;

        (new Thread(() -> Platform.runLater(() -> _pcs.firePropertyChange(null, null, null)))).start();
        _fsm.evolve();
    }
    public void startGame() {
        _fsm.pressKey();
        _pcs.firePropertyChange(null, null, null);
    }

    public void pauseGame() {
        _fsm.pause();
        _pcs.firePropertyChange(null, null, null);
    }

    public void resumeGame() {
        _fsm.resume();
        _pcs.firePropertyChange(null, null, null);
    }

    public void endGame() {
        _fsm.quit();
        _pcs.firePropertyChange(null, null, null);
    }

    public void loadLevel() { _fsm.loadLevel(); }

    public void loadTop5() {}

    public char[][] getMaze() { return _fsm.getMaze(); }
    public int getMazeWidth() { return _fsm.getMazeWidth(); }
    public int getMazeHeight() { return _fsm.getMazeHeight(); }
    public int getNumLevel() { return _fsm.getNumLevel(); }
    public int getPoints() { return _fsm.getPoints(); }
    public int getVidas() { return _fsm.getVidas(); }
    public GameContext getMazeContext() { return _fsm; }
    public EGameState getMazeState() {
        if (_fsm == null) return null;
        return _fsm.getState();
    }
    public EGhostState getBlinkyState() { return _fsm.getBlinkyState(); }
    public EGhostState getPinkyState() { return _fsm.getPinkyState(); }
    public EGhostState getInkyState() { return _fsm.getInkyState(); }
    public EGhostState getClydeState() { return _fsm.getClydeState(); }
    public EDirection getDirection() { return _fsm.getDirection(); }

    //TODO: função reset do state, setDirect, etc
    public void setMazeState(IGameState state) { _fsm.changeState(state); }
    public void setDirection(EDirection dir) { _fsm.setDirection(dir);  }
}
