package heureka.app;

import java.util.Iterator;
import java.util.PriorityQueue;

public class NodePriorityQueue<E> extends PriorityQueue<Node> {
	
	public Boolean containsState(State s){
		for (Node n : this){
			if (n.state == s){
				return true;
			}
		}
		return false;
	}
	
	public void replaceForHigherPathCost(Node child){
		for (Iterator<Node> iter = this.iterator(); iter.hasNext();){
			Node n = iter.next();
			if ( n.state == child.state && n.getfScore() > child.getfScore() ){
				iter.remove();
				this.add(child);
				return;
			}
		}
	}
}
