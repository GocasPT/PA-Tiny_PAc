package pt.isec.pa.tinypac.model.fsm;

import pt.isec.pa.tinypac.model.data.Maze;

abstract class MazeStateAdapter implements IMazeState {
    MazeContext _context;
    Maze _maze;

    protected MazeStateAdapter(MazeContext context, Maze maze) {
        this._context = context;
        this._maze = maze;
    }

    protected void changeState(EMazeState newState) { _context.changeState(newState.createState(_context, _maze)); }

    //@Override
}
