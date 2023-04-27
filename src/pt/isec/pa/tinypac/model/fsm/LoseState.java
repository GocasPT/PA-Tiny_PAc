package pt.isec.pa.tinypac.model.fsm;

import pt.isec.pa.tinypac.model.data.Maze;

public class LoseState extends MazeStateAdapter {
    public LoseState(MazeContext context, Maze maze) {
        super(context, maze);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.LOSE_STATE ;
    }
}
