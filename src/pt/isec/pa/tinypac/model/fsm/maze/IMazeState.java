package pt.isec.pa.tinypac.model.fsm.maze;

public interface IMazeState {
    void pressKey();
    void evolve();
    void pause();
    void resume();
    void save();
    void quit();
    EMazeState getState();
}
