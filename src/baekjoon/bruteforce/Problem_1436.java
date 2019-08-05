package baekjoon.bruteforce;

import java.util.Scanner;

import util.Problem;

public class Problem_1436 implements Problem {
	
	/*
	 * 1436 영화감독 숌 (https://www.acmicpc.net/problem/11279)
	 * 666들어간거 차례대로 확인해보기
	 */
	
	public static void main(String[] args) {
		Problem_1436 problem = new Problem_1436();
		
		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int endNum = getEndNum(N);
		
		System.out.println(endNum);
		
		scan.close();
	}
	
	
	public int getEndNum(int N) {
		int endNum = -1;
		int count = 0;
		int num = 666;
		
		String endNumString = "666";
		
		while(count < N) {
			String numString = String.valueOf(num);
			if(numString.contains(endNumString)) {
				endNum = num;
				count++;
			}
			num++;
		}
		
		return endNum;
	}
}
