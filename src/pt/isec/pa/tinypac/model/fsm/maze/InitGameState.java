package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public class InitGameState extends MazeStateAdapter {
    public InitGameState(MazeContext context, MazeManager manager, Maze maze){
        super(context, manager, maze);
    }

    @Override
    public void startGame() {
        System.out.println("O jogo começou");
        changeState(EMazeState.PLAYING_STATE);
    }

    @Override
    public void loadLevel() {
        System.out.println("A carregar maze...");
        _manager.loadLevel();
    }

    @Override
    public EMazeState getState() {
        return EMazeState.INIT_GAME_STATE;
    }
}
