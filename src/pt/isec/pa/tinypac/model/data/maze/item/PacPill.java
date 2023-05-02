package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class PacPill extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'O';
    public static final char RENDER = '⏺';

    public PacPill(Maze maze) {
        super(maze);
    }

    @Override
    public char getSymbol() { return RENDER; }
}
