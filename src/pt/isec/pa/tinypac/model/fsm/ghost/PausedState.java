package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.GameData;

public class PausedState extends GhostStateAdapter {
    public PausedState(GhostContext context, GameData data) { super(context, data); }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public EGhostState getState() { return EGhostState.PAUSED_STATE; }
}
