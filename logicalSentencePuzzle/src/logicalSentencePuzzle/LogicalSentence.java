package logicalSentencePuzzle;
public class LogicalSentence {
	public boolean truthValue;
	public LogicalSentence(){
	}
	/**
	 * Constructor for logical sentence
	 * @param prop is the proposition constant to be made a logical sentence out of
	 * Takes truth value of proposition constant
	 */
		public LogicalSentence(PropositionConstant prop){
		this.truthValue = prop.truthVal;
	}
	/**
	 * Evaluate class for conjunctions
	 * @param t is the truth assignment to be analyzed
	 * Takes truth assignment's recorded truth assignments and analyzes them both together
	 * @return the and value of both truth values
	 */
	public boolean evaluate(TruthAssignment t){
		if (this instanceof Conjunction){
			t.truthValues.add(this.truthValue);
			if (t.truthValues.get(0) == true){
				return true;
			}
		}
		return false;
	}
}
