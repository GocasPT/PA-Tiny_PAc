package pt.isec.pa.tinypac.model.fsm;

import pt.isec.pa.tinypac.model.data.Maze;

public class WinState extends MazeStateAdapter {
    public WinState(MazeContext context, Maze maze) {
        super(context, maze);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.WIN_STATE;
    }
}
