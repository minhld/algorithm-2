package com.usu.test.interviews;

public class test_0_usu extends Thread {
	public void run() {
		String[] res = chooseSteps(3, new int[] { 3, 1, 4 });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i] + " ");
		}
	}
	
	// contains the choices by numbers
	int[] steps = null;
	
	public String[] chooseSteps(int t, int[] n) {
		steps = new int[t];
		
		// contains the choices by strings: First or Second
		String[] stepsStr = new String[t]; 
		
		for (int i = 0; i < t; i++) {
			steps[i] = chooseStep(n[i]);
			stepsStr[i] = steps[i] == 1 ? "First" : "Second";
		}
		
		return stepsStr;
	}
	
	public int chooseStep(int n) {
		
		// if wave <= 2 just choose the first
		if (n <= 2) {
			steps[n] = 1;
			return steps[n];
		}
		
		// if the two previous steps are different, the next
		// step should be 1
		// because: if let the second person (SP) choose first,
		// he will choose and let us be in the next step where
		// we must be the second to win, while we have to shoot
		// right at this step
		steps[n] = chooseStep(steps[n - 1]) != chooseStep(steps[n - 2]) ? 1 : 2 ;
		
		return steps[n];
	}
	
	public static void main(String args[]) {
		new test_0_usu().start();
	}
}
