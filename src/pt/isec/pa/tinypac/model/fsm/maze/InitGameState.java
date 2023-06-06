package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public class InitGameState extends MazeStateAdapter {
    public InitGameState(MazeContext context, Maze maze){
        super(context, maze);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.INIT_GAME_STATE;
    }
}
