package heureka.app;

import java.util.ArrayList;

public abstract class Problem {

	public String initialState;
	
	abstract void setInitialState(String state);

	abstract Boolean goalTest(String state);

	abstract ArrayList<Action> actions(String state);
	
	abstract Double stepCost(String state, Action action);
	
	abstract String result(String state, Action action);
	

}
