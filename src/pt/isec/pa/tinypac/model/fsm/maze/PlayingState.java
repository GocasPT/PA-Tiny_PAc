package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class PlayingState extends MazeStateAdapter {
    public PlayingState(MazeContext context, Maze maze){
        super(context, maze);
    }

    @Override
    public void pressKey() {

    }

    @Override
    public void pause() {
        changeState(EMazeState.PAUSE_STATE);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.PLAYING_STATE;
    }
}
