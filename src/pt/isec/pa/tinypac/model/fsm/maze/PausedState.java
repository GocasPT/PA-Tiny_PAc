package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public class PausedState extends MazeStateAdapter {
    public PausedState(MazeContext context, MazeManager manager, Maze maze){
        super(context, manager, maze);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.PAUSE_STATE;
    }
}
