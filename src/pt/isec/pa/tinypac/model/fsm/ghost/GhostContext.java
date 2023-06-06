package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;
import pt.isec.pa.tinypac.model.data.maze.Maze;

public class GhostContext implements IGameEngineEvolve {
    private IGhostState _state;

    public GhostContext(Maze maze) {
        this._state = EGhostState.LOCK_IN_CASE_STATE.createState(this, maze);
    }

    void changeState(IGhostState newState) { _state = newState; }

    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {

    }

    public EGhostState getState() {
        if (_state == null)
            return null;
        return  _state.getState();
    }
}
