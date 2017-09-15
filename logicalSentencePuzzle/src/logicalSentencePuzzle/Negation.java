package logicalSentencePuzzle;

public class Negation extends LogicalSentence{
	public LogicalSentence log;
	public boolean truthValue;
	/**
	 * Negation constructor
	 * @param l is the logicalsentence to negate
	 * TruthValue of this is the opposite truthValue of l
	 */
	public Negation (LogicalSentence l){
		this.log = l;
		if (l.truthValue == true){
			this.truthValue = false;
		}else{
			this.truthValue = true;
		}
	}
}
