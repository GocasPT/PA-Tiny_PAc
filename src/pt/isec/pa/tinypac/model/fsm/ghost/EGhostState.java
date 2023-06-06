package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.maze.Maze;

public enum EGhostState {
    LOCK_IN_CASE_STATE, ATTACKING_STATE, VULNERABLE_STATE, GOING_BACK_CASE_STATE, PAUSED_STATE;

    public IGhostState createState(GhostContext context, Maze maze) {
        return switch (this) {
            case LOCK_IN_CASE_STATE -> new LockInCaseState(context, maze);
            case ATTACKING_STATE -> new AttackingState(context, maze);
            case VULNERABLE_STATE -> new VulnerableState(context, maze);
            case GOING_BACK_CASE_STATE -> new GoingBackCaseState(context, maze);
            case PAUSED_STATE -> new PausedState(context, maze);
        };
    }
}
