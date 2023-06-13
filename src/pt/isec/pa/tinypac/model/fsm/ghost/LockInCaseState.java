package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.GameData;

public class LockInCaseState extends GhostStateAdapter {
    public LockInCaseState(GhostContext context, GameData data) { super(context, data); }

    @Override
    public void pause() {
        changeState(EGhostState.PAUSED_STATE);
    }

    @Override
    public EGhostState getState() { return EGhostState.LOCK_IN_CASE_STATE; }
}
