package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;

abstract class GhostStateAdapter implements IGhostState {
    GhostContext _context;
    Maze _maze;

    protected GhostStateAdapter(GhostContext context, Maze maze) {
        this._context = context;
        this._maze = maze;
    };

    protected void changeState(EGhostState newState) { _context.changeState(newState.createState(_context, _maze)); }

    @Override
    public void evolve() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public EGhostState getState() {
        return null;
    }
}
