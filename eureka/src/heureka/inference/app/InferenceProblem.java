package heureka.inference.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InferenceProblem extends Problem{
	private String goalState;
	private ArrayList<Integer> CIDs = new ArrayList<Integer>();
	private Map<Integer,Clause> clauses = new HashMap<Integer,Clause>();
	
	public InferenceProblem() {
		ArrayList<String> var1 = new ArrayList<String>() {{
		    add("a");
		}};
		ArrayList<String> var2 = new ArrayList<String>() {{
		    add("b");
		    add("c");
		}};
		ArrayList<String> var3 = new ArrayList<String>() {{
		    add("b");
		}};
		ArrayList<String> var4 = new ArrayList<String>() {{
		    add("c");
		    add("d");
		}};
		ArrayList<String> var5 = new ArrayList<String>() {{
		    add("c");
		}};
		ArrayList<String> var6 = new ArrayList<String>() {{
		    add("d");
		}};
		ArrayList<String> var7 = new ArrayList<String>();
		
		Clause cl1 = new Clause(var1,var2,1);
		Clause cl2 = new Clause(var3,var3,2);
		Clause cl3 = new Clause(var3,var4,3);
		Clause cl4 = new Clause(var5,var7,4);
		Clause cl5 = new Clause(var6,var7,5);
		
		clauses.put(1,cl1);
		clauses.put(2,cl2);
		clauses.put(3,cl3);
		clauses.put(4,cl4);
		clauses.put(5,cl5);
		
		CIDs.add(1);
		CIDs.add(2);
		CIDs.add(3);
		CIDs.add(4);
		CIDs.add(5);
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
		ArrayList<Action> actionlist = new ArrayList<Action>();
		ArrayList<Integer> dummy = new ArrayList<Integer>();
		dummy.addAll(CIDs);
		dummy.removeAll(IDs);
		for(Integer ID: dummy){
			actionlist.add(new Action(ID));
		}

		return actionlist;
	}

	public ArrayList<Integer> getCIDs() {
		return CIDs;
	}
	
}
