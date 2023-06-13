package pt.isec.pa.tinypac.model.fsm.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import javafx.scene.input.KeyCode;

public interface IGameState {
    void pressKey(KeyType key); // Lanterna
    void pressKey(KeyCode key); // JavaFX
    void evolve();
    void pause();
    void resume();
    void save();
    void quit();
    EGameState getState();
}
