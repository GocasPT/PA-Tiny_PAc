package pt.isec.pa.tinypac.model.fsm.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import javafx.scene.input.KeyCode;
import pt.isec.pa.tinypac.model.data.GameData;

abstract class GameStateAdapter implements IGameState {
    protected GameContext _context;
    protected GameData _data;

    protected GameStateAdapter(GameContext context, GameData data) {
        _context = context;
        _data = data;
    }

    protected void changeState(EGameState newState) { _context.changeState(newState.createState(_context, _data)); }

    @Override
    public void pressKey(KeyType key) {}

    @Override
    public void pressKey(KeyCode key) {}

    @Override
    public void evolve() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void save() {}

    @Override
    public void quit() {}

    @Override
    public EGameState getState() { return null; }
}
