package pt.isec.pa.tinypac.model.fsm.game;

import com.googlecode.lanterna.input.KeyType;
import javafx.scene.input.KeyCode;
import pt.isec.pa.tinypac.model.data.GameData;
import pt.isec.pa.tinypac.model.data.EDirection;
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
        _data.movePacman();
    }*/

    public void loadLevel() { _data.loadLevel(); }
    public void changeState(IGameState newState) { _state = newState; }

    //TODO: check as funçoes de transições
    public void pressKey() { _state.pressKey(); }
    public void evolve() {
        _state.evolve();
        _fsmBlinky.evolve();
        _fsmPinky.evolve();
        _fsmInky.evolve();
        _fsmClyde.evolve();
    }
    public void pause() { _state.pause(); }
    public void resume() { _state.resume(); }
    public void save() { _state.save(); }
    public void quit() { _state.quit(); }

    // Gets do Gamedata
    public GameData getGameData() { return _data; }
    public int getVidas() { return _data.getVidas(); }
    public EDirection getDirection() { return _data.getDirection(); }
    public char[][] getMaze() { return _data.getMaze(); }
    public int getMazeWidth() { return _data.getMazeWidth(); }
    public int getMazeHeight() { return _data.getMazeHeight(); }
    public int getNumLevel() { return _data.getNumLevel(); }
    public int getPoints() { return _data.getPoints(); }
    public boolean getOnPowerUp() { return _data.getOnPowerUp(); }

    // Get do IGameState
    public EGameState getState() {
        if (_state == null)
            return null;
        return  _state.getState();
    }

    // Gets dos GhostContext's
    public EGhostState getBlinkyState() { return _fsmBlinky.getState(); }
    public EGhostState getPinkyState() { return _fsmPinky.getState(); }
    public EGhostState getInkyState() { return _fsmInky.getState(); }
    public EGhostState getClydeState() { return _fsmClyde.getState(); }

    // Set do GameData
    public void setDirection(EDirection dir) { _data.setDirection(dir); }
}
