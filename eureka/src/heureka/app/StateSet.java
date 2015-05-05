package heureka.app;

import java.util.HashSet;

public class StateSet<E> extends HashSet<State> {
	
	public Boolean containsState(State state){
		for (State s : this){
			if (s.customEquals(state)){
				return true;
			}
		}
		return false;
	}
}
