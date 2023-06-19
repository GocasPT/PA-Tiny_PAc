package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class PacmanSpawn extends MazeElement implements IMazeElement{
    public static final char SYMBOL = 'M';
    public PacmanSpawn(Maze maze) { super(maze); }

    @Override
    public char getSymbol() { return SYMBOL; }
}
