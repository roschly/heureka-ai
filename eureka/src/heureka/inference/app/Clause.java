package heureka.inference.app;

import java.util.ArrayList;
import java.util.List;

public class Clause {
	public int ID;
	public String state;
	public List<String> positive = new ArrayList<String>();
	public List<String> negative = new ArrayList<String>();
	public Clause parent;
	public List<Integer> IDs = new ArrayList<Integer>();
	public double gScore;
	public double hScore;
	
	public Clause(){}
	
	public Clause(List<String> positive, List<String> negative, int id){
		this.positive = positive;
		this.negative = negative;
		this.ID = id;
		this.state = this.toString();
		this.gScore = 0;
		this.hScore = positive.size() + negative.size();
	}
	
	public void childClause(Clause parent, InferenceProblem problem, Action action){
		this.parent = parent;
		this.positive.addAll(parent.positive);
		this.negative.addAll(parent.negative);
		action.resolution(parent);
		this.IDs.addAll(parent.IDs);
		if(IDs.contains(ID)){
			IDs.remove(ID);
		}
		this.gScore = parent.gScore + 1;
		this.state = this.toString();
	}
	
	public String toString(){
		String s = "";
		if(positive.size()>0) {
			for(String L : positive){
				s+=L +" ";
			}
		} if(negative.size()>0){
			s+="<";
			for(String L : positive){
				s+=L +" ";
			}
			return s;
		}
		return s;
	}

	public double getfScore() {
		return gScore + hScore;
	}

}
