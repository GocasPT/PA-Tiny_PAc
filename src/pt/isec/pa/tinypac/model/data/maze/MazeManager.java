package pt.isec.pa.tinypac.model.data.maze;

import pt.isec.pa.tinypac.model.ModelLog;

import pt.isec.pa.tinypac.model.data.maze.item.*;
import pt.isec.pa.tinypac.model.data.player.Pacman;

import java.io.*;
import java.util.List;

public class MazeManager {
    private Maze _maze;
    private static final String LEVEL_FOLDER = "files/Levels/";
    private static final String LOG_FILE = "files/Log.txt";
    private int _numLevel;

    public MazeManager() {
        this._maze = null;
        this._numLevel = 1;
        //loadLevel();
    }

    public void nextLevel() { _numLevel++; }

    public Maze loadLevel() {
        try {
            new FileWriter(LOG_FILE).close();
        } catch (IOException e) {

        }

        String levelFormat = String.format("%02d", _numLevel);
        String LEVEL = LEVEL_FOLDER+"Level"+levelFormat+".txt";

        _maze = readFile(LEVEL);
        if(_maze != null)
            return _maze;
        ModelLog.getInstance().add("file not found");
        return null;
    }

    private static Maze readFile(String filepath) {
        Maze newMaze = null;
        FileReader fr = null;

        try{
            File file = new File(filepath);

            if(!file.exists())
                return null;

            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int h = 0, w = 0;

            // Ler o tamanho da maze
            while ((line = br.readLine()) != null) {
                if (h == 0) {
                    w = line.length();
                }
                h++;
            }

            newMaze = new Maze(h, w);

            fr = new FileReader(file);
            br = new BufferedReader(fr);
            int x = 0;
            int y = 0;

            while((line = br.readLine()) != null){
                for(int i = 0; i < w; i++) {
                    char c = line.charAt(i);
                    MazeElement o = switch (c){
                        case Wall.SYMBOL -> new Wall(newMaze);
                        case Fruit.SYMBOL -> new Fruit(newMaze);
                        case PacDot.SYMBOL -> new PacDot(newMaze);
                        case PacPill.SYMBOL -> new PacPill(newMaze);
                        case Warp.SYMBOL -> new Warp(newMaze);
                        case 'M' -> new Pacman(newMaze);
                        case 'Y' -> new GhostCaseDoor(newMaze);
                        case 'y' -> new GhostCaseZone(newMaze);
                        default -> null;
                    };
                    if(!newMaze.set(y, x, o))
                        ModelLog.getInstance().add("Erro na introdução do item: "+o);
                    x++;
                }
                x=0;
                y++;
            }

        }catch(IOException e){
            e.printStackTrace();
        } finally {
            if (fr != null){
                try{
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return newMaze;
    }

    public void saveLogs() {
        try ( // este ciclo try fecha o filewriter sozinho ja nao precisamos de fazer close
              FileWriter fw = new FileWriter(LOG_FILE, true);
              PrintWriter pw = new PrintWriter(fw);
        ) {
            List<String > logs = ModelLog.getInstance().getLog();
            for(String msg:logs)
                pw.println(msg);
            ModelLog.getInstance().reset();

        }catch (IOException e){

        }catch (Exception e){

        }finally{

        }
    }

    public char[][] getMazeBoard() { return _maze.getMaze(); }
    public Maze getMaze() { return _maze; }
    public int getNumLevel() { return _numLevel; }
}
