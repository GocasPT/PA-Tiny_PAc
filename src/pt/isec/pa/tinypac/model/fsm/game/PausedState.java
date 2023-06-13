package pt.isec.pa.tinypac.model.fsm.game;

import pt.isec.pa.tinypac.model.data.GameData;

public class PausedState extends GameStateAdapter {
    public PausedState(GameContext context, GameData data){
        super(context, data);
    }

    @Override
    public void resume() {

    }

    @Override
    public void quit() {

    }

    @Override
    public EGameState getState() {
        return EGameState.PAUSE_STATE;
    }
}
