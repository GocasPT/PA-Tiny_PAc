package pt.isec.pa.tinypac;

import pt.isec.pa.tinypac.model.data.maze.MazeManager;
import pt.isec.pa.tinypac.ui.text.TinyPAcTUI;

import java.io.IOException;;

public class TinyPAcMain {
    public static void main(String[] args) throws IOException {
        MazeManager model = new MazeManager();
        TinyPAcTUI ui = new TinyPAcTUI(model);
        //TinyPAcGUI ui = new TinyPAcGUI(fsm);
        //GameEngine gameEngine = new GameEngine();
        ui.showMenu();

        //gameEngine.registerClient(ui);

        //gameEngine.waitForTheEnd();
    }
}