//Exercise 12

import static java.lang.Math.*;

public class SuiteNewton{
	public static void main(String[] args){
		double x = Double.parseDouble(args[0]);
		double un = x/2;
		double e = 1e-15;
		int counter = 0;

		while (Math.abs(un - x/un) > e && counter < 200) {
			un = (un + x/un)/2;
			System.out.println(un);
			counter += 1;
		}

		System.out.println("square root of " + String.format("%f", x) + " :  " + String.format("%f", un) + " / epsilon: 1e-15 ");
	}
}
