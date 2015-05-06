package heureka.app;

import java.util.ArrayList;

public class Solution {
	
	public Boolean exists;
	public ArrayList<Node> path = new ArrayList<Node>();

	public Solution(){
		this.exists = false; 
	}
	
	public Solution(Node node) {
		this.exists = true;
		
		//ArrayList<State> tempPath = new ArrayList<State>();
		Node currentNode = node;
		
		while (currentNode != null){
			this.path.add(0, currentNode);
			currentNode = currentNode.parent;
		}
	}
	
	public void printSolution(){
		for (Node node : path){
			if (node.action == null){
				System.out.println("Start with " + node.state);
			}
			else if (node.state.literals.size() == 0){
				System.out.println("++ " + node.action.result + " ==> []");
			}
			else {
			System.out.println("++ " + node.action.result + " ==> " + node.state);
			}
		}
	}

}
