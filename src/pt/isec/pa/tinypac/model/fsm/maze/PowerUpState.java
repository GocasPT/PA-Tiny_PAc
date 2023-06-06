package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class PowerUpState extends MazeStateAdapter {
    public PowerUpState(MazeContext context, Maze maze){
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
        return EMazeState.POWER_UP_STATE;
    }
}
