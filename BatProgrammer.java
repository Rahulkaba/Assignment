package ApyaCapitalServices;

import java.util.Scanner;

public class BatProgrammer {
	public static int findNumOfStepsRequired(int numPatients, int startingStep) {
	    int totalSteps = 0;
	    for (int i = 1; i <= numPatients; i++) {
	        totalSteps += i * startingStep; 
	        totalSteps += i * (i - 1) / 2; 
	    }
	    return totalSteps;
	}
  
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the pateint number");
		int numPatients=sc.nextInt();
		int startingStep=10;
		
	 int steps=findNumOfStepsRequired(numPatients, startingStep);
	 System.out.println("Total steps required to reach patient is  "+steps);
	}
}
