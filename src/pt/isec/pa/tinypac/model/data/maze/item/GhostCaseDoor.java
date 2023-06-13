package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class GhostCaseDoor extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'Y';

    public GhostCaseDoor(Maze maze) { super(maze); }

    @Override
    public char getSymbol() { return SYMBOL; }
}
