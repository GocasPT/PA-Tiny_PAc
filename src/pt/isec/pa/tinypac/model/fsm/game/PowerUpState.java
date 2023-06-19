package pt.isec.pa.tinypac.model.fsm.game;

import com.googlecode.lanterna.input.KeyType;
import javafx.scene.input.KeyCode;
import pt.isec.pa.tinypac.model.data.GameData;

public class PowerUpState extends GameStateAdapter {
    public PowerUpState(GameContext context, GameData data){
        super(context, data);
    }

    @Override
    public void pressKey() {}

    @Override
    public void pause() {
        changeState(EGameState.PAUSE_STATE);
    }

    @Override
    public void evolve() {
        _context.getGameData().movePacman();
        //_context.getGameData().moveGhosts();

        if (!_context.getOnPowerUp()) changeState(EGameState.PLAYING_STATE);
    }

    @Override
    public EGameState getState() {
        return EGameState.POWER_UP_STATE;
    }
}
