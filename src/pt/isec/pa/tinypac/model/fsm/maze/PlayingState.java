package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public class PlayingState extends MazeStateAdapter {
    public PlayingState(MazeContext context, MazeManager manager, Maze maze){
        super(context, manager, maze);
    }

    @Override
    public void pauseGame() {
        System.out.println("Jogo em pausa");
        changeState(EMazeState.PAUSE_STATE);
    }

    @Override
    public void resumeGame() {
        System.out.println("Jogo em prosseguimento");
        changeState(EMazeState.PLAYING_STATE);
    }

    @Override
    public void nextLevel() {
        System.out.println("Próximo nível");
        _manager.nextLevel();
        changeState(EMazeState.INIT_GAME_STATE);
    }

    @Override
    public void resetLevel() {
        System.out.println("Reiniciar nível");
        changeState(EMazeState.INIT_GAME_STATE);
    }

    @Override
    public EMazeState getState() {
        return EMazeState.PLAYING_STATE;
    }
}
