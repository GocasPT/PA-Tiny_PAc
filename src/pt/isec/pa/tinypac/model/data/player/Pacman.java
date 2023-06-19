package pt.isec.pa.tinypac.model.data.player;

import pt.isec.pa.tinypac.model.data.EDirection;
import pt.isec.pa.tinypac.model.data.ghost.Blinky;
import pt.isec.pa.tinypac.model.data.ghost.Clyde;
import pt.isec.pa.tinypac.model.data.ghost.Inky;
import pt.isec.pa.tinypac.model.data.ghost.Pinky;
import pt.isec.pa.tinypac.model.data.maze.item.*;
import pt.isec.pa.tinypac.model.data.maze.Maze;

public class Pacman extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'p';
    private int _vidas;
    private EDirection _direction;
    private IMazeElement _overElement;
    private int _points;
    private boolean _powerUpOn;

    public Pacman(Maze maze) {
        super(maze);
        _vidas = 3;
        _direction = EDirection.NONE;
        _points = 0;
        _powerUpOn = false;
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

        _maze.set(y, x, this);
    }

    private boolean colision(int y, int x) {
        IMazeElement element = _maze.get(y, x);

        if (element == null) return true;

        switch (element.getSymbol()) {
            case Wall.SYMBOL, GhostCaseDoor.SYMBOL -> {
                _direction = EDirection.NONE;
                return false;
            }

            case Blinky.SYMBOL, Pinky.SYMBOL, Inky.SYMBOL, Clyde.SYMBOL -> {
                /*if (PowerUpState) {
                    _points += 100;
                }
                else {*/
                    _vidas++;
                    return false;
                //}
            }

            case Fruit.SYMBOL -> {
                Fruit fruit = (Fruit) _maze.get(y, x);

                if (fruit.withFruit())
                    _points += 20;
                else
                    _overElement = _maze.get(y, x);
            }

            case PacDot.RENDER -> _points += 5;

            case PacPill.RENDER -> {
                _powerUpOn = true;
                _points += 10;
            }

            case Warp.SYMBOL -> {
                return false;
            }
        }

        return true;
    }

    @Override
    public char getSymbol() { return SYMBOL; }
    public int getVidas() { return _vidas; }
    public EDirection getDirection() { return _direction; }
    public int getPoints() { return _points; }
    public boolean getOnPowerUp() { return _powerUpOn; }

    public void setVidas (int vidas) { _vidas = vidas; }
    public void setDirection(EDirection dir) { _direction = dir; }
    public void setPoints(int points) { _points = points; }
    public void setPowerUp() { _powerUpOn = true; }
}
