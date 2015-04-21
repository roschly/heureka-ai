package heureka.app;

import java.util.ArrayList;

public abstract class Problem {

	public State initialState;

	abstract Boolean goalTest(State state2);

	abstract ArrayList<Action> actions(State state2);
	
	abstract int stepCost(State state, Action action);
	
	abstract State result(State state, Action action);
	

}
