package pt.isec.pa.tinypac.model.fsm.game;

import pt.isec.pa.tinypac.model.data.GameData;

public enum EGameState {
    INIT_GAME_STATE, PLAYING_STATE, PAUSE_STATE, POWER_UP_STATE, END_GAME_STATE;

    public IGameState createState(GameContext context, GameData data) {
        return switch (this) {
            case INIT_GAME_STATE -> new InitGameState(context, data);
            case PLAYING_STATE -> new PlayingState(context, data);
            case PAUSE_STATE -> new PausedState(context, data);
            case POWER_UP_STATE -> new PowerUpState(context, data);
            case END_GAME_STATE -> new EndGameState(context, data);
        };
    }
}
