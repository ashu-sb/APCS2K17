public class Intro {
	/**
	 * Problem 1: ret takes no methods and returns the integer 17
	 */
	public static int ret(){
		return 17;
	}
/**
 * Problem 2: The logic method
 * @param a A generic conditional boolean value
 * @param b A second generic conditional boolean value
 * @param c A third generic conditional boolean value
 * @return true if a, b and c are all true, false if not
 */
	public static boolean logic (boolean a, boolean b, boolean c){
		if (a == true && b == true && c == true){
			return true;
		}
		return false;
	}

/**
* Problem 3: Stars
* @param n The number of rows of the triangle specified by the main method
* n is converted into a variable for further reference in the method by adding 1 so the index value of 0 does not become a complication
* @return Triangle of stars formatted from an array of stars created through double looping
*/
	
	public static String stars(int n){
		int arrayLength = n + 1;
		//Array for creating triangle, String for formatting and output
		String [] str = new String[arrayLength];
		String strang = "";
		//Fills array with empty strings to avoid null outputs
		for(int h = 0; h < arrayLength; h++){
			str[h] = "";
		}
		//Iterates through array twice and adds star characters appropriately
		for (int i = 0; i < arrayLength; i++){
			for(int j = 0; j < i; j++){
				str[i] += "*";
			}
			//Every index value of the array becomes a row of the triangle
			strang += (str[i] + "\n");
		}
			return strang;
	}
/**
 * Problem 4: Coins
 * @param n is the value of the coins
 * Iterates through possible combinations of coins
 * @return the number of nickels and 2 cent coins or -1 if n cannot be equalled.
 */
	public static int coins(int n){
		//Tests if n is divisible by 5
		if (n % 5 == 0) return n / 5;
		//Sets nickels to max possible value and 2cents to 0 as a nickel > 2cent coin
		int nickels = n / 5;
		int twoCents = 0;
		//While total value != n and there is no negative number of coins
		while (((2 * twoCents) + (5 * nickels) != n) && nickels >= 0 && twoCents >= 0){
			//if n is even nickels are removed if their value is odd and if there are less than 10 cents in 2cent coins another 2cent is added
			if (n % 2 == 0){
				if (nickels % 2 == 1) nickels --;
				if (twoCents < 5) twoCents ++;
			//if n is odd nickels are removed if their value is even and if there are less than 8 cents in 2cent coins another 2cent is added
			}else if (n % 2 == 1){
				if (nickels % 2 == 0) nickels --;
				if (twoCents < 4) twoCents ++;
			}
			//With every iteration it is tested if the total value of coins adds up to n
			if ((2 * twoCents) + (5 * nickels) == n){
				return nickels + twoCents;
		}
		}	
		return -1;
	}
	
	public static void main(String[] args) {

	}
}
