package pt.isec.pa.tinypac.model.fsm;

import pt.isec.pa.tinypac.model.data.Maze;

public class PausedState extends MazeStateAdapter {
    public PausedState(MazeContext context, Maze maze) {
        super(context, maze);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.PAUSE_STATE;
    }
}
