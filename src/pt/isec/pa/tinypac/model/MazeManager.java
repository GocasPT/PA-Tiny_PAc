package pt.isec.pa.tinypac.model;

import pt.isec.pa.tinypac.gameengine.IGameEngine;
import pt.isec.pa.tinypac.gameengine.IGameEngineEvolve;
import pt.isec.pa.tinypac.model.data.Maze;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MazeManager implements IGameEngineEvolve {
    Maze _maze;

    private static final String LEVEL_FOLDER = "files/Levels/";
    private static final String LOG_FILE = "files/Log.txt";

    public MazeManager() {
        try {
            new FileWriter(LOG_FILE).close();
        } catch (IOException e) {

        }

        String LEVEL = LEVEL_FOLDER + "Level01.txt";

        _maze = readFile(LEVEL);
        if(_maze != null)
            return;
        ModelLog.getInstance().add("file not found");
        /*_maze = new Maze(10,10);
        for(int i = 0;i<10;i++) {
            int y = (int)(Math.random()*10);
            int x = (int)(Math.random()*10);
            _maze.addOrganism(new Virus(_maze),y,x);
        }

        for(int i = 0;i<10;i++) {
            int y = (int)(Math.random()*10);
            int x = (int)(Math.random()*10);
            _maze.addOrganism(new Evolver(_maze),y,x);
        }*/
    }

    private static Maze readFile(String filepath) {
        Maze newMaze = null;

        return newMaze;
    }

    public char[][] getEnvironment() {
        return _maze.getMaze();
    }

    private void saveLogs() {
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

    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {
        if(_maze == null)
            return;
        /*if(!_maze.evolve())
            gameEngine.stop();*/

        saveLogs();
    }
}
