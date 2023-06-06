package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class EndGameState extends MazeStateAdapter {
    public EndGameState(MazeContext context, Maze maze){
        super(context, maze);
    }

    @Override
    public void quit() {

    }

    @Override
    public EMazeState getState() {
        return EMazeState.END_GAME_STATE;
    }
}
