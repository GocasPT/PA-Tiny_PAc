package pt.isec.pa.tinypac.model.data.maze.item;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public class Fruit extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'F';

    public Fruit(Maze maze) { super(maze); }

    public boolean withFruit() {
        return false;
    }

    @Override
    public char getSymbol() { return SYMBOL; }
}
