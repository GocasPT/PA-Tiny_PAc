package pt.isec.pa.tinypac.model.fsm.game;

import com.googlecode.lanterna.input.KeyType;
import pt.isec.pa.tinypac.model.data.GameData;

public class PlayingState extends GameStateAdapter {
    public PlayingState(GameContext context, GameData data){ super(context, data); }

    @Override
    public void pressKey() {}

    @Override
    public void pause() {
        changeState(EGameState.PAUSE_STATE);
    }

    @Override
    public void evolve() {
        _context.getGameData().movePacman();

        if (_context.getOnPowerUp())
            changeState(EGameState.POWER_UP_STATE);



        if (_context.getVidas() < 1)
            changeState(EGameState.END_GAME_STATE);
    }

    @Override
    public EGameState getState() {
        return EGameState.PLAYING_STATE;
    }
}
