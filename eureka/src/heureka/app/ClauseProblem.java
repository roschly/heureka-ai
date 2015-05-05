package heureka.app;

import java.util.ArrayList;

public class ClauseProblem extends Problem{
	
	public State initialState;
	public Integer goalState;
	public ArrayList<State> KB = new ArrayList<State>();
	
	public ClauseProblem(){
		
		this.goalState = 0;
		this.initialState = new State( new Literal("a", -1) );
		
		
		// add states to KB
		
		/*
		Literal l1 = new Literal("a", 1);
		Literal l2 = new Literal("b", 1);
		*/
		
		this.KB.add( new State( new Literal("a", 1) ) );
		//this.KB.add( new State( new Literal("b", -1) ) );
		
		
	}

	@Override
	void setInitialState(State state) {
		this.initialState = state;
		
	}

	@Override
	Boolean goalTest(State state) {
		return state.literals.size() == this.goalState;
	}

	@Override
	ArrayList<Action> actions(State state) {
		
		ArrayList<Action> actions = new ArrayList<Action>();
		for (State clause : this.KB){
			actions.add( new Action("Apply", clause) );
		}
		
		return actions;
	}

	@Override
	Double stepCost(State state, Action action) {
		return 1.0;
	}

	@Override
	State result(State state, Action action) {
		
		if (action.type.equals("Apply")){
			
			for (Literal actionLit : action.result.literals){
				for (int i = 0; i < state.literals.size(); i++){
					if ( state.literals.get(i).negates(actionLit) ){
						state.literals.remove(i);
						break;
					}
						
					if (i == state.literals.size() - 1){
						state.literals.add(actionLit);
						break;
					}
					
				}
			}
			
		}
		
		return state;
	}
	
	
}
