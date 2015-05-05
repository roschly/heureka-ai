package heureka.app;

import java.util.ArrayList;

public abstract class Problem {

	public State initialState;
	
	abstract void setInitialState(State state);

	abstract Boolean goalTest(State state);

	abstract ArrayList<Action> actions(State state);
	
	abstract Double stepCost(State state, Action action);
	
	abstract State result(State state, Action action);
	

}
