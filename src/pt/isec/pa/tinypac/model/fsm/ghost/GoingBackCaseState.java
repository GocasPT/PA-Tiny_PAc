package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.GameData;

public class GoingBackCaseState extends GhostStateAdapter {
    public GoingBackCaseState(GhostContext context, GameData data) { super(context, data); }

    @Override
    public void pause() {
        changeState(EGhostState.PAUSED_STATE);
    }

    @Override
    public EGhostState getState() { return EGhostState.GOING_BACK_CASE_STATE; }
}
