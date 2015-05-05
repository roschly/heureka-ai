package Inference.app;

public class Solution {
	
	public Boolean exists;

	public Solution(){
		this.exists = false; 
	}
	
	public Solution(Clause clause) {
		this.exists = true;
	}

}
