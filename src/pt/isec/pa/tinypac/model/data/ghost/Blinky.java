package pt.isec.pa.tinypac.model.data.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.item.IMazeElement;
import pt.isec.pa.tinypac.model.data.maze.item.MazeElement;
import pt.isec.pa.tinypac.model.data.maze.item.Wall;
import pt.isec.pa.tinypac.model.data.maze.item.Warp;
import pt.isec.pa.tinypac.model.data.player.Pacman;

import java.util.ArrayList;
import java.util.Random;

public class Blinky extends Ghost{
    public static final char SYMBOL = 'B';

    public Blinky(Maze maze, IMazeElement elementOver) { super(maze, elementOver); }

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
        Random rand = new Random();
        int[] coor = findHim();

        if (coor == null) return;

        int x = coor[0];
        int y = coor[1];

        //TODO: atualizar a maze com o moviemto do ghost + colisiona muda a direction para null (?)
        _maze.set(y, x, _overElement);
        _overElement = null;

        switch (_direction) {
            case UP -> {
                if (colision(y - 1, x))
                    y--;
            }
            case DOWN -> {
                if (colision(y + 1, x))
                    y++;
            }
            case LEFT -> {
                if (colision(y, x - 1))
                    x--;
            }
            case RIGHT -> {
                if (colision(y, x + 1))
                    x++;
            }
        }

        _overElement = _maze.get(y, x);
        _maze.set(y, x, this);
    }

    @Override
    protected boolean colision(int y, int x) {
        IMazeElement element = _maze.get(y, x);

        if (element == null) return true;

        switch (element.getSymbol()) {
            case Wall.SYMBOL -> {
                /*
                ArrayList<IMazeElement> options = new ArrayList<IMazeElement>();

                if (_maze.get(y-1, x) == null)
                    options.add(_maze.get(y-1, x));
                if (_maze.get(y+1, x) == null)
                    options.add(_maze.get(y+1, x));
                if (_maze.get(y, x-1) == null)
                    options.add(_maze.get(y, x-1));
                if (_maze.get(y, x+1) == null)
                    options.add(_maze.get(y, x+1));

                //rand.nextInt();
                */

                return false;
            }

            case Pacman.SYMBOL -> {
                //if (Vulnerable)
                return false;
            }

            //case PacDot.SYMBOL, PacPill.SYMBOL -> {}

            case Warp.SYMBOL -> {
                return false;
            }
        }

        return true;
    }

    @Override
    public char getSymbol() { return SYMBOL; }
}
