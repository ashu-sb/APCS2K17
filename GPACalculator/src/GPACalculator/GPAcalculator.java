package GPACalculator;
import java.util.Scanner;
public class GPAcalculator {
	//array of character grades
	static char[] grades;
	//initial GPA
	static int gpa = 0;
	//number of weighted classes = number of points to be added for weighted GPA
	static int weightedClasses = 0;
	//scanner for user input
	static Scanner scan = new Scanner(System.in);
	//iterates through grades and adds to gpa accordingly
	public static double[] calculate(char[] input){
		for(int i = 0; i < input.length; i++){
			if(input[i] == 'A'){
				gpa += 4;
			}else if (input[i] == 'B'){
				gpa += 3;
			}else if (input[i] == 'C'){
				gpa += 2;
			}else if (input[i] == 'D'){
				gpa += 1;
			}
		}
		//calculates unweighted gpa
		double unweightedGPA = ((double)gpa/(double)input.length);
		//calculates weighted gpa
		double weightedGPA = (((double)gpa + (double)weightedClasses)/(2*(double)input.length));
		//returns the two in encapsulated form
		double [] gpas = {unweightedGPA, weightedGPA};
		return gpas;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to the GPA calculator. Please enter how many AP and honors classes you have taken.");
		weightedClasses = scan.nextInt();
		System.out.println("Enter your grades below. Your GPA (both weighted and unweighted) will be calculated.");
		grades = scan.next().toCharArray();
		System.out.println("The unweighted GPA is: " + calculate(grades)[0]);
		System.out.println("The weighted GPA is: " + calculate(grades)[1]);
	}
}
