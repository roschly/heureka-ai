package heureka.app;

import java.util.ArrayList;

public class State {
	public ArrayList<Literal> literals = new ArrayList<Literal>();
	
	public State(){}
	
	public State(String clause){
		String[] strLiterals = clause.split(" ");
		
		for (String strLit : strLiterals){
			this.literals.add( new Literal( strLit ) );
		}
	}
	
	public String toString(){
		String str = "";
		for (Literal lit : this.literals){
			if (lit.sign == -1){
				str += "-" + lit.letter + " " ;
			}
			else {
				str += lit.letter + " " ;
			}
			
		}
		return str;
	}
	
	public Boolean customEquals(State state){
		if (this.literals.size() != state.literals.size()){
			return false;
		}
		
		for (Literal thisLit : this.literals){
			for (int i = 0; i < state.literals.size(); i++){
				
				if (thisLit.customEquals( state.literals.get(i) )){
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
