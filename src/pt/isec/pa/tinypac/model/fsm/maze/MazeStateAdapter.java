package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;
import pt.isec.pa.tinypac.model.fsm.maze.EMazeState;
import pt.isec.pa.tinypac.model.fsm.maze.IMazeState;
import pt.isec.pa.tinypac.model.fsm.maze.MazeContext;

abstract class MazeStateAdapter implements IMazeState {
    MazeContext _context;
    MazeManager _manager;
    Maze _maze;

    protected MazeStateAdapter(MazeContext context,MazeManager manager, Maze maze) {
        this._context = context;
        this._manager = manager;
        this._maze = maze;
    }

    protected void changeState(EMazeState newState) { _context.changeState(newState.createState(_context, _manager, _maze)); }

    @Override
    public void startGame() {}
    @Override
    public void loadLevel() {}
    @Override
    public void nextLevel() {}
    @Override
    public void resetLevel() {}
    @Override
    public void pauseGame() {}
    @Override
    public void resumeGame() {}
    @Override
    public void powerUp() {}
    @Override
    public void gameOver() {}
    @Override
    public void gameComplete() {}

    @Override
    public EMazeState getState() {
        return null;
    }
}
