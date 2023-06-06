package pt.isec.pa.tinypac.model.fsm.maze;

import com.googlecode.lanterna.input.KeyStroke;
import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;
import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.fsm.ghost.EGhostState;
import pt.isec.pa.tinypac.model.fsm.ghost.GhostContext;

public class MazeContext implements IGameEngineEvolve {
    private IMazeState _state;
    private GhostContext _fsmBlinky;
    private GhostContext _fsmPinky;
    private GhostContext _fsmInky;
    private GhostContext _fsmClyde;
    //private GameEngine _gameEngine;

    public MazeContext(Maze maze) {
        //TODO: check parametrus de entrada da criação do objeto
        this._state = EMazeState.INIT_GAME_STATE.createState(this, maze);
        this._fsmBlinky = new GhostContext(maze);
        this._fsmPinky = new GhostContext(maze);
        this._fsmInky = new GhostContext(maze);
        this._fsmClyde = new GhostContext(maze);
    }

    //TODO: verificar este evolve (este é o evolve do gameEngine)
    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {

    }

    void changeState(IMazeState newState) { _state = newState; }

    //TODO: check as funçoes de transições
    public void pressKey() { _state.pressKey(); }
    public void evolve() { _state.evolve(); }
    public void pause() { _state.pause(); }
    public void resume() { _state.resume(); }
    public void save() { _state.save(); }
    public void quit() { _state.quit(); }

    public EMazeState getState() {
        if (_state == null)
            return null;
        return  _state.getState();
    }
    public EGhostState getBlinkyState() { return _fsmBlinky.getState(); }
    public EGhostState getPinkyState() { return _fsmPinky.getState(); }
    public EGhostState getInkyState() { return _fsmInky.getState(); }
    public EGhostState getClydeState() { return _fsmClyde.getState(); }

    //TODO: funçao reset de state
    //public void setState(EMazeState state) { _state.EMazeState.state.createState(this, maze); }
}
