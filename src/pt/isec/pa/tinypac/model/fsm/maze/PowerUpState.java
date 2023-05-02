package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public class PowerUpState extends MazeStateAdapter {
    public PowerUpState(MazeContext context, MazeManager manager, Maze maze){
        super(context, manager, maze);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.POWER_UP_STATE;
    }
}
