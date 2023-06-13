package pt.isec.pa.tinypac.model.fsm.game;

import pt.isec.pa.tinypac.model.data.GameData;

public class EndGameState extends GameStateAdapter {
    public EndGameState(GameContext context, GameData data){
        super(context, data);
    }

    @Override
    public void quit() {

    }

    @Override
    public EGameState getState() {
        return EGameState.END_GAME_STATE;
    }
}
