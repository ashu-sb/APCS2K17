package logicalSentencePuzzle;
public class PropositionConstant {
	private String name;
	/**truth value of constant*/
	public boolean truthVal;
	public PropositionConstant(String name){
		this.name = name;
	}
	/**truth value setter*/
	public void setTruthValue(boolean truth){
		this.truthVal = truth;
	}
}
