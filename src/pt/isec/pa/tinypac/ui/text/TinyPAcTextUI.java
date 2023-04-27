package pt.isec.pa.tinypac.ui.text;

//  import tinypac package
import pt.isec.pa.tinypac.model.fsm.EMazeState;
import pt.isec.pa.tinypac.model.fsm.MazeContext;
import pt.isec.pa.tinypac.gameengine.IGameEngine;

//  import lanterna package
import com.googlecode.lanterna.*;

public class TinyPAcTextUI {
    MazeContext _fsm;
    IGameEngine _gameEngine;

    public TinyPAcTextUI(MazeContext fsm, IGameEngine gameEngine) {
        this._fsm = fsm;
        this._gameEngine = gameEngine;
    }

    private boolean _finish = false;

    public void start() {
        //TODO: interface à base de texto
        showMenu();

        //TODO: janela do jogo
        while (!_finish) {
            switch (_fsm.getState()) {
                case INIT_GAME_STATE -> _fsm.load();
                case PLAYING_STATE -> _fsm.start();
                case PAUSE_STATE -> {
                    _gameEngine.pause();
                }
                case POWER_UP_STATE -> {
                    _gameEngine.setInterval(5000);
                };
                case WIN_STATE -> {
                    showEndScree(EMazeState.WIN_STATE);
                }
                case LOSE_STATE -> {
                    showEndScree(EMazeState.LOSE_STATE);
                }
                default -> _finish = true;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
    }

    private void showTop5() {
        System.out.println("Top5");
    }

    private void showEndScree(EMazeState type) {
        switch (type) {
            case WIN_STATE -> {
                System.out.println("Win");
            }
            case LOSE_STATE -> {
                System.out.println("Lose");
            }
        }
    }
}
