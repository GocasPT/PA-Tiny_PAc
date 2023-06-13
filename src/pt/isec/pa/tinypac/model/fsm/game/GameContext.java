package pt.isec.pa.tinypac.model.fsm.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import javafx.scene.input.KeyCode;
import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;
import pt.isec.pa.tinypac.model.data.GameData;
import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.player.EPacmanDirection;
import pt.isec.pa.tinypac.model.fsm.ghost.EGhostState;
import pt.isec.pa.tinypac.model.fsm.ghost.GhostContext;

import java.util.ArrayList;

public class GameContext {
    private GameData _data;
    private IGameState _state;
    private ArrayList<IGameState> _statesHistory;
    private GhostContext _fsmBlinky;
    private GhostContext _fsmPinky;
    private GhostContext _fsmInky;
    private GhostContext _fsmClyde;
    //private GameEngine _gameEngine;

    public GameContext() {
        //TODO: check parametrus de entrada da criação do objeto
        _data = new GameData();
        _state = EGameState.INIT_GAME_STATE.createState(this, _data);
        _statesHistory = new ArrayList<IGameState>();
        _fsmBlinky = new GhostContext(_data);
        _fsmPinky = new GhostContext(_data);
        _fsmInky = new GhostContext(_data);
        _fsmClyde = new GhostContext(_data);
    }

    //TODO: verificar este evolve (este é o evolve do gameEngine)
    /*public void evolve() {
        _data.moveElements();
    }*/

    public void resetFSM() { _state = EGameState.INIT_GAME_STATE.createState(this, _data); }
    public void loadLevel() { _data.loadLevel(); }

    public void changeState(IGameState newState) { _state = newState; }

    //TODO: check as funçoes de transições
    public void pressKey(KeyType key) { _state.pressKey(key); } //Lanterna
    public void pressKey(KeyCode key) { _state.pressKey(key); } //JavaFX
    public void evolve() { _state.evolve(); }
    public void pause() { _state.pause(); }
    public void resume() { _state.resume(); }
    public void save() { _state.save(); }
    public void quit() { _state.quit(); }

    public GameData getGameData() { return _data; }
    public EGameState getState() {
        if (_state == null)
            return null;
        return  _state.getState();
    }
    public char[][] getMaze() { return _data.getMaze(); }
    public int getNumLevel() { return _data.getNumLevel(); }
    public EGhostState getBlinkyState() { return _fsmBlinky.getState(); }
    public EGhostState getPinkyState() { return _fsmPinky.getState(); }
    public EGhostState getInkyState() { return _fsmInky.getState(); }
    public EGhostState getClydeState() { return _fsmClyde.getState(); }
    public EPacmanDirection getDirection() { return _data.getDirection(); }

    public void setDirection(EPacmanDirection dir) { _data.setDirection(dir); }
}
