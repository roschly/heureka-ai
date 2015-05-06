package heureka.app;

import java.util.ArrayList;
import java.util.Iterator;

public class ClauseProblem extends Problem{
	
	public State initialState;
	public Integer goalState;
	public ArrayList<State> KB = new ArrayList<State>();

	
	public ClauseProblem(){
		
		this.goalState = 0;
		this.initialState = new State( "-a" );
		
		
		// Has solution 
		this.KB.add( new State("a -b") );
		this.KB.add( new State("b -c") );
		this.KB.add( new State("c") );
		
		
		/*
		// No solution, infinite loop
		this.KB.add( new State("a -b") );
		this.KB.add( new State("b -c") );
		*/
	}


	void setInitialState(State state) {
		this.initialState = state;
	}

	Boolean goalTest(State state) {
		return state.literals.size() == this.goalState;
	}

	ArrayList<Action> actions(State state) {
		ArrayList<Action> actions = new ArrayList<Action>();
		for (State clause : this.KB){
			actions.add( new Action("Apply", clause) );
		}
		return actions;
	}

	Double stepCost(State state, Action action) {
		return 1.0;
	}

	State result(State state, Action action) {
			State resultState = new State();
		if (action.type.equals("Apply")){
			// resultState gets all the literals from action state
			for (Literal actionLit : action.result.literals){
				resultState.literals.add(actionLit);
			}
			
			for (Literal stateLit : state.literals){
				for (Iterator<Literal> iter = resultState.literals.iterator(); iter.hasNext();){
					Literal resLit = iter.next();
					
					// if stateLit is customEquals to some lit in resultState, don't add it
					if (stateLit.customEquals(resLit)){
						break;
					}
					
					// if stateLit negates some lit in resultState, remove that lit from result and don't add stateLit
					if ( stateLit.negates(resLit) ){
						iter.remove();
						break;
					}
					
					// if it hasn't negated anything or is not customEqual to anything, add it
					if ( !iter.hasNext() ){
						resultState.literals.add(stateLit);
						break;
					}
				}
			}
		}
		return resultState;
	}
	
	public Double heuristicFunction(State state){
		return (double) state.literals.size();
	}
	
}
