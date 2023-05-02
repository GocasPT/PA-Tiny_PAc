package pt.isec.pa.tinypac.model.data.player;

import com.googlecode.lanterna.input.KeyStroke;
import pt.isec.pa.tinypac.model.data.maze.item.IMazeElement;
import pt.isec.pa.tinypac.model.data.maze.item.MazeElement;
import pt.isec.pa.tinypac.model.data.maze.Maze;

public class Pacman extends MazeElement implements IMazeElement {
    public static final char SYMBOL = 'P';
    private int _vidas;
    private KeyStroke _direction;
    private boolean _moving;

    public Pacman(Maze maze) {
        super(maze);
        this._vidas = 3;
        this._direction = null;
        this._moving = false;
    }

    public void move() {
        while (_moving) {
            /*switch (_direction) {
                case 'r' -> ;
                case 'l' -> ;
                case 'u' -> ;
                case 'd' -> ;
            }*/
        }
    }

    public void colision(IMazeElement item) {
        /*
        switch (_direction) {
            case 'r' -> ;
            case 'l' -> ;
            case 'u' -> ;
            case 'd' -> ;
        }

        if()
        */
    }

    @Override
    public char getSymbol() {
        return SYMBOL;
    }

    public void setDirection(KeyStroke key) {
        /*switch (key) {
            case ArrowUp -> {

            }
        }*/
    }
}
