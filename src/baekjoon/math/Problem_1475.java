package baekjoon.math;

import java.util.Scanner;

import util.Problem;

public class Problem_1475 implements Problem {

	/*
	 * 1475 방 번호(https://www.acmicpc.net/problem/1475)
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		Problem_1475 problem = new Problem_1475();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int[] roomNumberCount = new int[10];
		
		int N = scan.nextInt();
		
		int tempNum = N;
		int digitsOfNum = 1;
		int result = 1;
		
		while(tempNum / digitsOfNum > 0) {
			digitsOfNum *= 10;
			int remainder = tempNum % digitsOfNum;
			tempNum -= remainder;
			
			int oneDigitRemainder = remainder / (digitsOfNum / 10);
			
//			System.out.println("tempNum : " + tempNum + " remainder : " + remainder + " oneDigitRemainder : " + oneDigitRemainder);
			
			if(oneDigitRemainder == 6)
				oneDigitRemainder = 9;
			
			roomNumberCount[oneDigitRemainder]++;	
		}
		
		int max = result;
		int lastMax = max;
		int maxIdx = 0;
		
		for(int i = 0; i < roomNumberCount.length; i++) {
			System.out.print(roomNumberCount[i] + " ");
			if(roomNumberCount[i] > 0 && roomNumberCount[i] >= max) {
				lastMax = max;
				max = roomNumberCount[i];
				maxIdx = i;
			}	
		}
		
		if(maxIdx == 9) {
			if(max / 2 == lastMax)
				result = max / 2;
			else
				result = max / 2 + lastMax;
		}
//		System.out.println();
		System.out.println(result);
		scan.close();
	}
}
