package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class GhostCaseZone extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'y';

    public GhostCaseZone(Maze maze) { super(maze); }

    @Override
    public char getSymbol() { return SYMBOL; }
}
