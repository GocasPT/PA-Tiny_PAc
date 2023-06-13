package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class PacDot extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'o';
    public static final char RENDER = '▪';

    public PacDot(Maze maze) { super(maze); }

    @Override
    public char getSymbol() { return RENDER; }
}
