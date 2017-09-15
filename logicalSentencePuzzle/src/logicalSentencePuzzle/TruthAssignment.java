package logicalSentencePuzzle;
import java.util.ArrayList;
public class TruthAssignment {
	/**arraylist that contains recorded assigned truth values*/
	public ArrayList<Boolean> truthValues = new ArrayList<Boolean>();
	public TruthAssignment(){	
	}
	/**assigns truth values and records them in the above arraylist*/
	public void put(PropositionConstant p, boolean truth){
		p.setTruthValue(truth);
	}
}
