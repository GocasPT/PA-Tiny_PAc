package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.fsm.maze.EMazeState;

public class LockInCaseState extends GhostStateAdapter {
    public LockInCaseState(GhostContext context, Maze maze) { super(context, maze); }

    @Override
    public void pause() {
        changeState(EGhostState.PAUSED_STATE);
    }

    @Override
    public EGhostState getState() { return EGhostState.LOCK_IN_CASE_STATE; }
}
