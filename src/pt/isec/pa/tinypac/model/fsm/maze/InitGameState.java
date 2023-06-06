package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class InitGameState extends MazeStateAdapter {
    public InitGameState(MazeContext context, Maze maze){
        super(context, maze);
    }

    //TODO: função de transição
    @Override
    public void pressKey() {
        changeState(EMazeState.PLAYING_STATE);
    }

    @Override
    public void quit() {

    }

    @Override
    public EMazeState getState() {
        return EMazeState.INIT_GAME_STATE;
    }
}
