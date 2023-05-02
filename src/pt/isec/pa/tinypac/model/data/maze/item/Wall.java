package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class Wall extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'x';

    public Wall(Maze maze) {
        super(maze);
    }

    @Override
    public char getSymbol() { return SYMBOL; }
}
