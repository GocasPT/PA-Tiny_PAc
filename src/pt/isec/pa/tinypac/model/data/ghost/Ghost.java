package pt.isec.pa.tinypac.model.data.ghost;

import pt.isec.pa.tinypac.model.data.EDirection;
import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.item.*;
import pt.isec.pa.tinypac.model.data.player.Pacman;

public abstract class Ghost extends MazeElement {
    protected IMazeElement _overElement;
    protected EDirection _direction;

    protected Ghost(Maze maze, IMazeElement elementOver) {
        super(maze);
        _overElement = elementOver;
        _direction = EDirection.NONE;
    }

    protected int[] findHim() { return null; }
    public void move() { }
    protected boolean colision(int y, int x) { return false; }
}
