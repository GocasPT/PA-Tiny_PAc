package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.GameData;

public enum EGhostState {
    LOCK_IN_CASE_STATE, ATTACKING_STATE, VULNERABLE_STATE, GOING_BACK_CASE_STATE, PAUSED_STATE;

    public IGhostState createState(GhostContext context, GameData data) {
        return switch (this) {
            case LOCK_IN_CASE_STATE -> new LockInCaseState(context, data);
            case ATTACKING_STATE -> new AttackingState(context, data);
            case VULNERABLE_STATE -> new VulnerableState(context, data);
            case GOING_BACK_CASE_STATE -> new GoingBackCaseState(context, data);
            case PAUSED_STATE -> new PausedState(context, data);
        };
    }
}
