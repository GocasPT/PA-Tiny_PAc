package pt.isec.pa.tinypac.model.fsm.ghost;

import pt.isec.pa.tinypac.model.data.GameData;

abstract class GhostStateAdapter implements IGhostState {
    private GhostContext _context;
    private GameData _data;

    protected GhostStateAdapter(GhostContext context, GameData data) {
        _context = context;
        _data = data;
    };

    protected void changeState(EGhostState newState) { _context.changeState(newState.createState(_context, _data)); }

    @Override
    public void evolve() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public EGhostState getState() {
        return null;
    }
}
