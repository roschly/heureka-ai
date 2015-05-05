package heureka.inference.app;

import java.util.ArrayList;

public class InferenceProblem extends Problem{
	private String goalState;

	@Override
	Boolean goalTest(String s) {
		return s.equals(getGoalState());
	}

	@Override
	ArrayList<Action> actions(String state2) {
		return null;
	}

	@Override
	int stepCost(String string, Action action) {
		return 1;
	}

	@Override
	String result(String string, Action action) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoalState() {
		return goalState;
	}

	public void setGoalState(String goalState) {
		this.goalState = goalState;
	}
	
}
