package heureka.app;

public class Action {
	public String type;
	public State result;
	
	
	public Action(String type, State result){
		// TODO: data validation
		this.type = type;
		this.result = result;
	}

}
