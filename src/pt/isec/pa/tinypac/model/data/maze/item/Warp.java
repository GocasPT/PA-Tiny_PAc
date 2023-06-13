package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class Warp extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'W';

    public Warp(Maze maze) { super(maze); }

    @Override
    public char getSymbol() { return SYMBOL; }
}
