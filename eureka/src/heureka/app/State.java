package heureka.app;

import java.util.ArrayList;

public class State {
	public ArrayList<Literal> literals = new ArrayList<Literal>();
	
	public State(ArrayList<Literal> literals){
		this.literals = literals;
	}
	
	public State(Literal lit){
		this.literals.add(lit);
	}
	
	public String toString(){
		String str = "";
		for (Literal lit : this.literals){
			str += lit.sign + lit.letter + " " ;
		}
		return str;
	}
	
	public Boolean customEquals(State state){
		if (this.literals.size() != state.literals.size()){
			return false;
		}
		
		for (Literal thisLit : this.literals){
			for (int i = 0; i < state.literals.size(); i++){
				if ( thisLit.letter.equals( state.literals.get(i).letter ) && thisLit.sign.equals( state.literals.get(i).sign ) ){
					break;
				}
				// end of list
				if (i == state.literals.size() - 1){
					return false;
				}
			}
		}
		return true;
	}
	
}
