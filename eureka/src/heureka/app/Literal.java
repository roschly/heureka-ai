package heureka.app;

public class Literal {
	public String letter;
	public Integer sign;
	
	public Literal(String letter, Integer sign){
		this.letter = letter;
		this.sign = sign;
	}
	
	public Boolean negates(Literal lit){
		if (this.letter.equals(lit.letter) && this.sign != lit.sign){
			return true;
		}
		else {
			return false;
		}
	}
}
