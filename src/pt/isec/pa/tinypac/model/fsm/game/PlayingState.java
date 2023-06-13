package pt.isec.pa.tinypac.model.fsm.game;

import com.googlecode.lanterna.input.KeyType;
import javafx.scene.input.KeyCode;
import pt.isec.pa.tinypac.model.data.GameData;

public class PlayingState extends GameStateAdapter {
    public PlayingState(GameContext context, GameData data){ super(context, data); }

    @Override
    public void pressKey(KeyType key) {

    }

    @Override
    public void pressKey(KeyCode key) {

    }

    @Override
    public void pause() {
        changeState(EGameState.PAUSE_STATE);
    }

    @Override
    public void evolve() {
        _context.getGameData().moveElements();
    }

    @Override
    public EGameState getState() {
        return EGameState.PLAYING_STATE;
    }
}
