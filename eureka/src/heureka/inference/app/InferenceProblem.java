package heureka.inference.app;

import java.util.ArrayList;
import java.util.List;

public class InferenceProblem extends Problem{
	private String goalState;
	private int[] CIDs;
	
	public InferenceProblem() {
		String[] var1 = {"a"};
		String[] var2 = {"b","c"};
		String[] var3 = {"b"};
		String[] var4 = {"c", "d"};
		String[] var5 = {"c"};
		String[] var6 = {"d"};
		String[] var7 =  new String[0];
		
		Clause cl1 = new Clause(var1,var2,1);
		Clause cl2 = new Clause(var3,var3,2);
		Clause cl3 = new Clause(var3,var4,3);
		Clause cl4 = new Clause(var5,var7,4);
		Clause cl5 = new Clause(var6,var7,5);
		
		CIDs = new int[] {1,2,3,4,5};
		
	}

	@Override
	Boolean goalTest(String s) {
		return s.equals(getGoalState());
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

	@Override
	ArrayList<Action> actions(List<Integer> IDs) {

		return null;
	}
	
}
