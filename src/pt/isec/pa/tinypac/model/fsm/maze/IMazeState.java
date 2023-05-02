package pt.isec.pa.tinypac.model.fsm.maze;

public interface IMazeState {
    void startGame();
    void loadLevel();
    void nextLevel();
    void resetLevel();
    void pauseGame();
    void resumeGame();
    void powerUp();
    //void powerDown();
    void gameOver();
    void gameComplete();

    EMazeState getState();
}
