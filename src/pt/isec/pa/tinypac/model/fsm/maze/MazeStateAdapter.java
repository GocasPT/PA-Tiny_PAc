package pt.isec.pa.tinypac.model.fsm.maze;

import pt.isec.pa.tinypac.model.data.maze.Maze;

abstract class MazeStateAdapter implements IMazeState {
    MazeContext _context;
    Maze _maze;

    protected MazeStateAdapter(MazeContext context, Maze maze) {
        this._context = context;
        this._maze = maze;
    }

    protected void changeState(EMazeState newState) { _context.changeState(newState.createState(_context, _maze)); }

    @Override
    public void pressKey() {}

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
    public EMazeState getState() { return null; }
}
