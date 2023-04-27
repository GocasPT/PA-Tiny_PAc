package pt.isec.pa.tinypac.model.fsm;

import pt.isec.pa.tinypac.model.data.Maze;

public class PowerUpState extends MazeStateAdapter {
    public PowerUpState(MazeContext context, Maze maze) {
        super(context,  maze);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.POWER_UP_STATE;
    }
}
