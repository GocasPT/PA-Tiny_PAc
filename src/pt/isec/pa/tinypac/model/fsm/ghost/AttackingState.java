package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.GameData;

public class AttackingState extends GhostStateAdapter {
    public AttackingState(GhostContext context, GameData data) { super(context, data); }

    @Override
    public void pause() {
        changeState(EGhostState.PAUSED_STATE);
    }

    @Override
    public EGhostState getState() { return EGhostState.ATTACKING_STATE; }
}
