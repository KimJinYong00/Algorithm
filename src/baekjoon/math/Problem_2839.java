package baekjoon.math;

import java.util.Scanner;

import util.Problem;

public class Problem_2839 implements Problem {

	/*
	 * 2839 설탕 배달(https://www.acmicpc.net/problem/2839)
	 */
	public static void main(String[] args) {
		Problem_2839 problem = new Problem_2839();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		boolean isCorrect = false;
		int val5 = N / 5;
		int val3 = N / 3;
		int remain5;
		int remain3;
		
		if(val5 < 1 && val3 < 1)
			System.out.println("-1");
		else {
			remain5 = N % 5;
			
			if(remain5 == 0) {
				System.out.println(val5);
				isCorrect = true;
			}
			else {
				for(int i = val5; i >= 0; i--) {
					val3 = remain5 / 3;
					remain3 = remain5 % 3;
					
					if(remain3 == 0) {
						System.out.println(val3 + i);
						isCorrect = true;
						break;
					}
					else {
						remain5 += 5;
					}
				}
			}
			
			if(!isCorrect)
				System.out.println("-1");
		}
		scan.close();
	}
}
