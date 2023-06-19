package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;
import pt.isec.pa.tinypac.model.data.GameData;
import pt.isec.pa.tinypac.model.data.ghost.Ghost;
import pt.isec.pa.tinypac.model.data.maze.Maze;

public class GhostContext {
    private IGhostState _state;

    public GhostContext(GameData data) {
        _state = EGhostState.LOCK_IN_CASE_STATE.createState(this, data);
    }

    void changeState(IGhostState newState) { _state = newState; }

    public void evolve() { _state.evolve(); }
    public void pause() { _state.pause(); }
    public void resume() { _state.resume(); }

    public EGhostState getState() {
        if (_state == null)
            return null;
        return  _state.getState();
    }
}
