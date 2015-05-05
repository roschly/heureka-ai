package heureka.inference.app;

import java.util.ArrayList;

public abstract class Problem {

	public String initialState;

	abstract Boolean goalTest(String state2);

	abstract ArrayList<Action> actions(String state2);
	
	abstract int stepCost(String string, Action action);
	
	abstract String result(String string, Action action);
	

}
