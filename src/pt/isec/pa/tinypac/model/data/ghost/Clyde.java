package pt.isec.pa.tinypac.model.data.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.item.GhostCaseZone;
import pt.isec.pa.tinypac.model.data.maze.item.IMazeElement;
import pt.isec.pa.tinypac.model.data.maze.item.MazeElement;

public class Clyde extends Ghost{
    public static final char SYMBOL = 'C';

    public Clyde(Maze maze, IMazeElement elementOver) { super(maze, elementOver); }

    @Override
    protected int[] findHim() {
        int x, y;

        for (y = 0; y < _maze.getMaze().length; y++) {
            for (x = 0; x < _maze.getMaze()[0].length; x++) {
                IMazeElement IElement = _maze.get(y, x);
                if (IElement != null && IElement instanceof MazeElement &&  IElement.equals(this)) {
                    return new int[] { x, y };
                }
            }
        }
        return null;
    }

    @Override
    public void move() {

    }

    @Override
    public char getSymbol() { return SYMBOL; }
}
