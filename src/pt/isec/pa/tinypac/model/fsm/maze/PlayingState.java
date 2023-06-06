package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public class PlayingState extends MazeStateAdapter {
    public PlayingState(MazeContext context, Maze maze){
        super(context, maze);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.PLAYING_STATE;
    }
}
