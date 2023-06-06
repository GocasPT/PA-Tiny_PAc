package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class PausedState extends GhostStateAdapter {
    public PausedState(GhostContext context, Maze maze) { super(context, maze); }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public EGhostState getState() { return EGhostState.PAUSED_STATE; }
}
