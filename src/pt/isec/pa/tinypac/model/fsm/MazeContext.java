package pt.isec.pa.tinypac.model.fsm;

import pt.isec.pa.tinypac.model.data.Maze;

public class MazeContext {
    IMazeState _state;
    Maze _maze;

    public MazeContext(int height, int width) {
        _maze = new Maze(height, width);
        _state = EMazeState.INIT_GAME_STATE.createState(this, _maze);
    }

    void changeState(IMazeState newState) { _state = newState; }

    public EMazeState getState() {
        if (_state == null)
            return null;
        return  _state.getState();
    }
}
