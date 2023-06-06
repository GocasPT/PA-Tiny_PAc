package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class AttackingState extends GhostStateAdapter {
    public AttackingState(GhostContext context, Maze maze) { super(context, maze); }

    @Override
    public void pause() {
        changeState(EGhostState.PAUSED_STATE);
    }

    @Override
    public EGhostState getState() { return EGhostState.ATTACKING_STATE; }
}
