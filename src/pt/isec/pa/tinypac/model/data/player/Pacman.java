package pt.isec.pa.tinypac.model.data.player;

import pt.isec.pa.tinypac.model.data.maze.item.IMazeElement;
import pt.isec.pa.tinypac.model.data.maze.item.MazeElement;
import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.item.Wall;

public class Pacman extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'p';
    private int _vidas;
    private EPacmanDirection _direction;

    public Pacman(Maze maze) {
        super(maze);
        _vidas = 3;
        _direction = EPacmanDirection.NONE;
    }

    public int[] findHim() {
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

    public void move() {
        int[] coor = findHim();
        if (coor == null) return;

        int x = coor[0];
        int y = coor[1];

        //TODO: atualizar a maze com o moviemto do pacman + colisiona muda a direction para null (?)
        _maze.set(y, x, null);
        switch (_direction) {
            case UP -> {
                if (_maze.get(y-1, x).getSymbol() == Wall.SYMBOL) {
                    _direction = EPacmanDirection.NONE;
                } else {
                    y--;
                }
            }
            case DOWN -> {
                if (_maze.get(y+1, x).getSymbol() == Wall.SYMBOL) {
                    _direction = EPacmanDirection.NONE;
                } else {
                    y++;
                }
            }
            case LEFT -> {
                if (_maze.get(y, x-1).getSymbol() == Wall.SYMBOL) {
                    _direction = EPacmanDirection.NONE;
                } else {
                    x--;
                }
            }
            case RIGHT -> {
                if (_maze.get(y, x+1).getSymbol() == Wall.SYMBOL) {
                    _direction = EPacmanDirection.NONE;
                } else {
                    x++;
                }
            }
        }

        _maze.set(y, x, this);
    }

    @Override
    public char getSymbol() { return SYMBOL; }
    public int getVidas() { return _vidas; }
    public EPacmanDirection getDirection() { return _direction; }

    public void setDirection(EPacmanDirection dir) { _direction = dir; }
}
