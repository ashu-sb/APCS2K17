package logicalSentencePuzzle;

public class logicalSentencePuzzle {
	/**
	 * legal method determines if a logical statement (compound or not) is legal
	 * @param stmt The logical statement in question
	 * Regex determines if the statement is legal
	 * @return a boolean stating if a logical sentence is legal
	 */
	public static boolean legal (String stmt){
		if (stmt.matches("\\w([&|^=]\\w)?")){
			return true;
		}
		return false;
	}
	/**
	 * TruthTable method prints a truth table for up to 2 proposition constants
	 * @param x the array containing the proposition constants
	 */
	public static void truthTable(String[] x){
		for(int i = 0; i < x.length; i++){
			System.out.print(x[i] + " ");
		}
		System.out.println("");
		if(x.length == 1){
		for(int i = 0; i < x.length; i++){
			System.out.println("T");
			System.out.println("F");
		}	
		}else if (x.length == 2){
			System.out.println("T T");
			System.out.println("T F");
			System.out.println("F T");
			System.out.println("F F");
		}
	}
	/**
	 * findMatch method finds the rightmost index of a string without parentheses given the same string with parentheses
	 * @param str is the string with parentheses to be converted to substrings that are combined into another string
	 * @param num is not used
	 * @return the length minus one (equal to the index of the last character) of the string w/o parentheses
	 */
	public static int findMatch(String str, int num){
		String s = str.substring(0, str.indexOf("(")) + str.substring(str.indexOf("(") + 1, str.indexOf(")"));
		return s.indexOf(s.charAt(s.length()-1));
	}
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4));
		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b, true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

		String[] pc = {"p"};
		truthTable(pc);
	}
}
