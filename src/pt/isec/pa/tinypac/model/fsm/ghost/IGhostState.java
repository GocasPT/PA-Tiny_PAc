package pt.isec.pa.tinypac.model.fsm.ghost;

public interface IGhostState {
    void evolve();
    void pause();
    void resume();
    EGhostState getState();
}
