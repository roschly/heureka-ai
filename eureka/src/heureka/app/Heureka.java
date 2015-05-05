package heureka.app;

public class Heureka {
	
	public static void main(String args[]){
		
		/*
		// test
		State s1 = new State( "b -c -a" );
		State s2 = new State( "b -c -a" );
		
		Literal l1 = new Literal( "c" );
		Literal l2 = new Literal( "c" );
		
		System.out.println(s1.customEquals(s2));
		*/
		
		ClauseProblem problem = new ClauseProblem();
		Solution s = Algorithms.aStarSearch(problem);
		System.out.println(s.exists);
		
		
	}
}
