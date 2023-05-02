package pt.isec.pa.tinypac.model.fsm.maze;

import com.googlecode.lanterna.input.KeyStroke;
import pt.isec.pa.tinypac.gameengine.GameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;
import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public class MazeContext implements IGameEngineEvolve {
    private IMazeState _state;
    private MazeManager _manager;
    //private GameEngine _gameEngine;

    public MazeContext() {
        this._manager = new MazeManager();
        this._state = EMazeState.INIT_GAME_STATE.createState(this, _manager, _manager.getMaze());
    }

    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {
        _manager.saveLogs();
    }

    void changeState(IMazeState newState) { _state = newState; }

    public void startGame() { _state.startGame(); }
    public void loadLevel() { _state.loadLevel(); }
    //TODO: _gameEngine.PAUSED
    public void pauseGame() { _state.pauseGame(); }
    //TODO: _gameEngine.RESUME
    public void resumeGame() { _state.resumeGame(); }
    public void powerUp() { _state.powerUp(); }
    public void gameOver() { _state.gameOver(); }
    public void gameComplete() { _state.gameComplete(); }

    public EMazeState getState() {
        if (_state == null)
            return null;
        return  _state.getState();
    }

    public char[][] getMazeBoard() { return _manager.getMazeBoard(); }

    public void setMaze(MazeManager manager) { this._manager = manager; }
    public void setPacmanDirection(KeyStroke key) { }
}
