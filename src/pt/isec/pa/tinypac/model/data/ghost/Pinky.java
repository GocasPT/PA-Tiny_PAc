package pt.isec.pa.tinypac.model.data.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.item.GhostCaseZone;
import pt.isec.pa.tinypac.model.data.maze.item.IMazeElement;

public class Pinky extends Ghost{
    public static final char SYMBOL = 'P';

    public Pinky(Maze maze, IMazeElement elementOver) { super(maze, elementOver); }

    @Override
    public char getSymbol() { return SYMBOL; }
}
