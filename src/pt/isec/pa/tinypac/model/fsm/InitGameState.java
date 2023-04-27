package pt.isec.pa.tinypac.model.fsm;

import pt.isec.pa.tinypac.model.data.Maze;

public class InitGameState extends MazeStateAdapter {
    public InitGameState(MazeContext context, Maze maze){
        super(context, maze);
    }

    public void load() {
        System.out.println("A carregar maze...");
    }

    public void pressKey() {
        boolean pressedKey = false;
        if (pressedKey) {
            System.out.println("Mudar para estado para jogar...");
        }
    }

    @Override
    public EMazeState getState() {
        return EMazeState.INIT_GAME_STATE;
    }
}
