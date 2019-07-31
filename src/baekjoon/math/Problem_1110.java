package baekjoon.math;

import java.util.Scanner;

import util.Problem;

public class Problem_1110 implements Problem {

	/*
	 * 1110 더하기 사이클(https://www.acmicpc.net/problem/1110)
	 * 간단한 문제
	 */
	public static void main(String[] args) {
		Problem_1110 problem = new Problem_1110();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int one = getOne(N);
		int ten = getTen(N);
		
		int cycle = 1;
		
		while(true) {
			int sum = one + ten;
			
			int newOne = getOne(sum);
			
			int newNum = one * 10 + newOne;
			
			if(newNum == N) {
				break;
			} 
			else {
				one = getOne(newNum);
				ten = getTen(newNum);
				cycle++;
			}
		}
		
		System.out.println(cycle);
		scan.close();
	}
	
	public int getOne(int num) {
		return num % 10;
	}
	
	public int getTen(int num) {
		return num / 10;
	}
}
