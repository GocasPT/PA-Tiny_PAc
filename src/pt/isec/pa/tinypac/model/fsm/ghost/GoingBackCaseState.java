package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class GoingBackCaseState extends GhostStateAdapter {
    public GoingBackCaseState(GhostContext context, Maze maze) { super(context, maze); }

    @Override
    public void pause() {
        changeState(EGhostState.PAUSED_STATE);
    }

    @Override
    public EGhostState getState() { return EGhostState.GOING_BACK_CASE_STATE; }
}
