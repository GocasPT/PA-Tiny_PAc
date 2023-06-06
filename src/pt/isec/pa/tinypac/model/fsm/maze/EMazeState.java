package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;

public enum EMazeState {
    INIT_GAME_STATE, PLAYING_STATE, PAUSE_STATE, POWER_UP_STATE, END_GAME_STATE;

    public IMazeState createState(MazeContext context, Maze maze) {
        return switch (this) {
            case INIT_GAME_STATE -> new InitGameState(context, maze);
            case PLAYING_STATE -> new PlayingState(context, maze);
            case PAUSE_STATE -> new PausedState(context, maze);
            case POWER_UP_STATE -> new PowerUpState(context, maze);
            case END_GAME_STATE -> new EndGameState(context, maze);
        };
    }
}
