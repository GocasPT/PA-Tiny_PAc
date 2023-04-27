package pt.isec.pa.tinypac.model.fsm;

import pt.isec.pa.tinypac.model.data.Maze;

public class PlayingState extends MazeStateAdapter {
    public PlayingState(MazeContext context, Maze maze) {
        super(context, maze);
    }

    public void start() {
        System.out.println("O jogo começou");
    }

    @Override
    public EMazeState getState() {
        return EMazeState.PLAYING_STATE;
    }
}
