package pt.isec.pa.tinypac.model.fsm.game;

import pt.isec.pa.tinypac.model.data.GameData;

public class InitGameState extends GameStateAdapter {
    public InitGameState(GameContext context, GameData data){
        super(context, data);
    }

    //TODO: função de transição
    @Override
    public void pressKey() {
        changeState(EGameState.PLAYING_STATE);
    }


    //TODO: ver se esta transiçõ faz sentido
    /*@Override
    public void quit() {

    }*/

    @Override
    public EGameState getState() {
        return EGameState.INIT_GAME_STATE;
    }
}
