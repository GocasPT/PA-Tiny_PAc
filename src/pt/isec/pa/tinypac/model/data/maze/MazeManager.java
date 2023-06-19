package pt.isec.pa.tinypac.model.data.maze;

import pt.isec.pa.tinypac.model.data.maze.item.*;

import java.io.*;
import java.util.*;

public class MazeManager {
    private static final String LEVEL_FOLDER = "files/Levels/";
    private static final String SAVE_FILE = "files/Save.dat";
    private Maze _maze;
    private int _width = 0;
    private int _height = 0;
    private List<GhostCaseZone> _ghostCaseArea;
    private GhostCaseDoor _ghostCaseDoor;
    private Fruit _fruitSpawn;
    private List<Warp> _warpsList;
    private PacmanSpawn _pacmanSpawn;
    private final Map<Integer, String> _levels = new HashMap<>();
    private int _totalPacDots = 0;

    public MazeManager(int level) {
        _ghostCaseArea = new ArrayList<>();
        _warpsList = new ArrayList<>();
        importLevelsFiles();
        loadLevel(level);

    }

    private void importLevelsFiles() {
        File folder = new File(LEVEL_FOLDER);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String levelName = file.getName();
                    int levelId = getLevelIdFromName(levelName);
                    _levels.put(levelId, levelName);
                }
            }
        }
    }
    //TODO: verifica a função getLevelIdFromName()
    private int getLevelIdFromName(String levelName) {
        String[] parts = levelName.split("\\.");
        String nameWithoutExtension = parts[0];
        String levelNumber = nameWithoutExtension.substring(5);
        return Integer.parseInt(levelNumber);
    }

    public void loadLevel(int level) {
        File file = new File(LEVEL_FOLDER+getLevelFile(level));
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            this._height++;
            this._width = line.length();
        }
        reader.close();

        this._maze = new Maze(this._height, this._width);

        try {
            reader = new Scanner(file);

            int y = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                for (int x = 0; x < line.length(); x++) {
                    char c = line.charAt(x);
                    switch (c) {
                        case Wall.SYMBOL -> {
                            _maze.set(y, x, new Wall(_maze));
                        }
                        case PacDot.SYMBOL -> {
                            _maze.set(y, x, new PacDot(_maze));
                            //totalPacDots++;
                        }
                        case Fruit.SYMBOL -> {
                            _fruitSpawn = new Fruit(_maze);
                            _maze.set(y, x, _fruitSpawn);
                            //totalPacDots++;
                        }
                        case PacPill.SYMBOL -> {
                            _maze.set(y, x, new PacPill(_maze));
                            //totalPacDots++;
                        }
                        case GhostCaseDoor.SYMBOL -> {
                            _ghostCaseDoor = new GhostCaseDoor(_maze);
                            _maze.set(y, x, _ghostCaseDoor);
                        }
                        case GhostCaseZone.SYMBOL -> {
                            GhostCaseZone ghostCaseZone = new GhostCaseZone(_maze);
                            _ghostCaseArea.add(ghostCaseZone);
                            _maze.set(y, x, ghostCaseZone);
                        }
                        case Warp.SYMBOL ->{
                            _maze.set(y, x, new Warp(_maze));
                        }
                        case PacmanSpawn.SYMBOL -> {
                            _pacmanSpawn = new PacmanSpawn(_maze);
                            _maze.set(y, x, _pacmanSpawn);
                        }
                    }
                }
                y++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Level file don't find!");
            e.printStackTrace();
        }
    }

    //TODO: função para carregar ficheiro binário save
    public void loadSave() {
        try {
            new FileWriter(SAVE_FILE).close();;
        } catch (IOException e) {

        }

        //TODO: carregar save e config sas variavis
    }

    public int[] findElement(MazeElement element) {
        int x, y;

        for (y = 0; y < _maze.getMaze().length; y++) {
            for (x = 0; x < _maze.getMaze()[0].length; x++) {
                IMazeElement IElement = _maze.get(y, x);
                if (IElement != null && IElement instanceof MazeElement &&  IElement.equals(element)) {
                    return new int[] { x, y };
                }
            }
        }
        return null;
    }

    public Maze getMaze() { return _maze; }
    public int getMazeWidth() { return _width; }
    public int getMazeHeight() { return _height; }
    public List<GhostCaseZone> getGhostCaseZone() { return _ghostCaseArea; }
    public GhostCaseDoor getGhostCaseDoor() { return _ghostCaseDoor; }
    public Fruit getFruitSpawn() { return _fruitSpawn; }
    public List<Warp> getWarpsList() { return _warpsList; }
    public PacmanSpawn getPacmanSpawn() { return _pacmanSpawn; }
    public int getTotalPacDots() { return _totalPacDots; }
    public String getLevelFile(int level) { return _levels.get(level); }
}
