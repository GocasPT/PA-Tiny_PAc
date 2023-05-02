package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public enum EMazeState {
    INIT_GAME_STATE, PLAYING_STATE, PAUSE_STATE, POWER_UP_STATE, WIN_STATE, LOSE_STATE;

    public IMazeState createState(MazeContext context, MazeManager manager, Maze maze) {
        return switch (this) {
            case INIT_GAME_STATE -> new InitGameState(context, manager, maze);
            case PLAYING_STATE -> new PlayingState(context, manager, maze);
            case PAUSE_STATE -> new PausedState(context, manager, maze);
            case POWER_UP_STATE -> new PowerUpState(context, manager, maze);
            case WIN_STATE -> new WinState(context, manager, maze);
            case LOSE_STATE -> new LoseState(context, manager, maze);
        };
    }
}
