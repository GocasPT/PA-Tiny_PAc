package pt.isec.pa.tinypac.model.data.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.item.IMazeElement;
import pt.isec.pa.tinypac.model.data.maze.item.MazeElement;

public abstract class Ghost extends MazeElement {
    protected IMazeElement _overElement;
    protected Ghost(Maze maze, IMazeElement elementOver) {
        super(maze);
        _overElement = elementOver;
    }

    protected void move() { }
}
