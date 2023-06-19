package pt.isec.pa.tinypac.model.data;

import pt.isec.pa.tinypac.model.data.ghost.*;
import pt.isec.pa.tinypac.model.data.maze.Maze;
import pt.isec.pa.tinypac.model.data.maze.MazeManager;
import pt.isec.pa.tinypac.model.data.maze.item.GhostCaseZone;
import pt.isec.pa.tinypac.model.data.maze.item.IMazeElement;
import pt.isec.pa.tinypac.model.data.maze.item.PacmanSpawn;
import pt.isec.pa.tinypac.model.data.maze.item.Warp;
import pt.isec.pa.tinypac.model.data.player.Pacman;

import java.util.ArrayList;
import java.util.Random;

//TODO: config da MazeData
public class GameData {
    private MazeManager _mazeManager;
    private Maze _maze;
    private int _numLevel = 1;
    private int _points;
    private int _time;
    private Pacman _pacman;
    private ArrayList<Ghost> _ghostList;
    private ArrayList<Warp> _warpList;
    //private ArrayList<MazeElement> _mazeElementList;

    public GameData() { initGame(); }

    public void initGame() {
        _mazeManager = new MazeManager(_numLevel);
        _maze = _mazeManager.getMaze();
        _pacman = new Pacman(_maze);
        _ghostList = new ArrayList<>();
        _warpList = new ArrayList<>();
        //_mazeElementList = new ArrayList<>();
        spawnPacMan();
        spawnGhosts();
    }

    private void spawnPacMan() {
        int h = _mazeManager.getMazeHeight();
        int w = _mazeManager.getMazeWidth();

        for(int x = 0; x < w; x++) {
            for(int y = 0; y < h; y++) {
                IMazeElement element = _maze.get(y, x);
                if (element instanceof PacmanSpawn) {
                        _maze.set(y, x, _pacman);
                }
            }
        }
    }

    private void spawnGhosts() {
        int h = _mazeManager.getMazeHeight();
        int w = _mazeManager.getMazeWidth();
        int i = 1;
        Random rand = new Random();

        while (_ghostList.size() < 4) {
            for(int x = 0; x < w; x++) {
                for(int y = 0; y < h; y++) {
                    IMazeElement element = _maze.get(y, x);
                    if (element instanceof GhostCaseZone) {
                        if (rand.nextInt(101) < 25) {
                            Ghost ghost = null;
                            switch (i) {
                                case 1 -> {
                                    ghost = new Blinky(_maze, _maze.get(y, x));
                                    i++;
                                }
                                case 2 -> {
                                    ghost = new Pinky(_maze, _maze.get(y, x));
                                    i++;
                                }
                                case 3 -> {
                                    ghost = new Inky(_maze, _maze.get(y, x));
                                    i++;
                                }
                                case 4 -> {
                                    ghost = new Clyde(_maze, _maze.get(y, x));
                                    i++;
                                }
                            }

                            if (ghost == null) continue;

                            _maze.set(y, x, ghost);
                            _ghostList.add(ghost);
                        }
                    }
                }
            }
        }
    }

    public void movePacman() { _pacman.move(); }
    public void moveGhosts() { for (Ghost ghost: _ghostList) ghost.move(); }

    public void loadLevel() { _mazeManager.loadLevel(_numLevel); }

    public MazeManager getMazeManager() { return _mazeManager; }
    public Maze getMazeClass() { return _maze; }
    public int getNumLevel() { return _numLevel; }
    public int getPoints() { return _pacman.getPoints(); }
    public char[][] getMaze() { return _maze.getMaze(); }
    public int getMazeWidth() { return _mazeManager.getMazeWidth(); }
    public int getMazeHeight() { return _mazeManager.getMazeHeight(); }
    public int getVidas() { return _pacman.getVidas(); }
    public EDirection getDirection() { return _pacman.getDirection(); }
    public boolean getOnPowerUp() { return _pacman.getOnPowerUp(); }

    //TODO: set dos objetos para a maze
    public void setNumLevel(int level) { _numLevel = level; }
    public void setDirection(EDirection dir) { _pacman.setDirection(dir);}
}
