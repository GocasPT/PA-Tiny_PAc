package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public abstract class MazeElement implements IMazeElement {
    protected static final char SYMBOL = ' ';
    protected Maze _maze;
    protected MazeElement(Maze maze) { _maze = maze; }

    @Override
    public char getSymbol() { return SYMBOL; }
}
