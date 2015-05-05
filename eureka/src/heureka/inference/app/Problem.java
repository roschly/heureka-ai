package heureka.inference.app;

import java.util.ArrayList;
import java.util.List;

public abstract class Problem {

	public String initialState;

	abstract Boolean goalTest(String state2);

	abstract ArrayList<Action> actions(List<Integer> IDs);
	
	abstract int stepCost(String string, Action action);
	
	abstract String result(String string, Action action);
	

}
