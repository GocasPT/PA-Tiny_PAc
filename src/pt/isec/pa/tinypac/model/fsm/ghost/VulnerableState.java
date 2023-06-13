package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.GameData;

public class VulnerableState extends GhostStateAdapter {
    public VulnerableState(GhostContext context, GameData data) { super(context, data); }

    @Override
    public void pause() {
        changeState(EGhostState.PAUSED_STATE);
    }

    @Override
    public EGhostState getState() { return EGhostState.VULNERABLE_STATE; }
}
