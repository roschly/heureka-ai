package heureka.app;

import java.util.Iterator;
import java.util.PriorityQueue;

public class NodePriorityQueue<E> extends PriorityQueue<Clause> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Boolean containsState(String s){
		for (Clause n : this){
			if (n.state == s){
				return true;
			}
		}
		return false;
	}
	
	public void replaceForHigherPathCost(Clause child){
		for (Iterator<Clause> iter = this.iterator(); iter.hasNext();){
			Clause n = iter.next();
			if ( n.state == child.state && n.getfScore() > child.getfScore() ){
				iter.remove();
				this.add(child);
				return;
			}
		}
	}
}
