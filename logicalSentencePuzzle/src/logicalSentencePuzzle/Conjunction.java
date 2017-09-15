package logicalSentencePuzzle;
public class Conjunction extends LogicalSentence{
	public LogicalSentence log1;
	public LogicalSentence log2;
	/**truth value of both sentences together*/
	public boolean truthValue;
	public Conjunction (LogicalSentence log1, LogicalSentence log2){
		this.log1 = log1;
		this.log2 = log2;
		if(log1.truthValue == true && log2.truthValue == true){
			this.truthValue = true;
		}else{
			this.truthValue = false;
		}
		
	}
	
}
