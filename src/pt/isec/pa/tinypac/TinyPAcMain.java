package pt.isec.pa.tinypac;

import pt.isec.pa.tinypac.gameengine.*;

import pt.isec.pa.tinypac.model.fsm.maze.MazeContext;
import pt.isec.pa.tinypac.ui.text.TinyPAcTextUI;

import java.io.IOException;;

public class TinyPAcMain {
    public static void main(String[] args) throws IOException {
        MazeContext fsm = new MazeContext();
        TinyPAcTextUI ui = new TinyPAcTextUI(fsm);
        //GameEngine gameEngine = new GameEngine();
        ui.startGame();

        //gameEngine.registerClient(ui);

        //gameEngine.waitForTheEnd();
    }
}