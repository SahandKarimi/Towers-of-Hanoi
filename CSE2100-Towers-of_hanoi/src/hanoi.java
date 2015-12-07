import java.util.Scanner;

/**
 * Towers of Hanoi
 * @author Ryan Carmellini
 */
public class hanoi {
	
	static int n = 4;  //number of disks on stack
	
	static int counter = 0;
	static char A = 'A'; 
	static char B = 'B';
	static char C = 'C';
	
	//Towers of Hanoi Puzzle
	//The three pegs go from left to right A, B, C
	public static void main(String[] args)
	{
		System.out.println("n = " + n);
		solve(n, A, B, C);
		System.out.println("number of moves: " + counter);
		System.out.println("expected number of moves: " + calculateExpected(n));
		System.out.println("result == " + test(counter, n));
	}
	
	public static void solve(int num, char a, char b, char c)
	{
		if(num == 1)
		{
			System.out.println(a + " --> " + c);
			counter++;
		}
		else
		{
			solve(num - 1, a, c, b);
			solve(1, a, b, c);
			solve(num - 1, b, a, c);
		}
	}
	
	//proof by mathematical induction
	//the actual number of moves is being compared to the calculated minimum number of moves
	public static boolean test(int act, int calc) 
	{
		return act == calculateExpected(calc);
	}
	
	//the minimum number of moves required is 2^n - 1
	public static int calculateExpected(int calc)
	{
		return (int) (Math.pow(2, calc) - 1);
	}
}
