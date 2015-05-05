package heureka.app;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class NodePriorityQueue<E> extends PriorityQueue<Node> {
	
	public NodePriorityQueue(int capacity, Comparator<? super Node> c){
		super(capacity, c);
	}
	
	public Boolean containsState(String state){
		for (Node node : this){
			if (node.state == state){
				return true;
			}
		}
		return false;
	}
	
	public void replaceForHigherPathCost(Node child){
		for (Iterator<Node> iter = this.iterator(); iter.hasNext();){
			Node node = iter.next();
			if ( node.state == child.state && node.pathCost > child.pathCost ){
				iter.remove();
				this.add(child);
				return;
			}
		}
	}
}
