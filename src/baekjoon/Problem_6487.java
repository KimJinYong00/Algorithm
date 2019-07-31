package baekjoon;

import java.util.Scanner;

import util.Problem;

public class Problem_6487 implements Problem {

	/*
	 * 6487 두 직선의 교차 여부 (https://www.acmicpc.net/problem/6487)
	 */
	public static void main(String[] args) {
		Problem_6487 problem = new Problem_6487();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] x = new int[4];
		int[] y = new int[4];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 4; j++) {
				x[j] = scan.nextInt();
				y[j] = scan.nextInt();
			}
			
			String status = isSameLine(x, y);
			
			if(status.equals("LINE") || status.equals("NONE")) {
				System.out.println(status);
			}
			else {
				float[] cp = getCrossPoint(x, y);
				
				System.out.printf(status + " %.2f  %.2f\n", cp[0], cp[1]);
			}
			
		}
		
		scan.close();
	}

	public float[] getCrossPoint(int[] x, int[] y) {
		float[] cp = new float[2];
		
		float p1Son = ((x[0] * y[1] - y[0] * x[1]) * (x[2] - x[3])) - ((x[2] * y[3] - y[2] * x[3]) * (x[0] - x[1]));
		float p1Parent = ((x[0] - x[1]) * (y[2] - y[3])) - ((x[2] - x[3]) * (y[0] - y[1]));
		
		float p2Son = ((x[0] * y[1] - y[0] * x[1]) * (y[2] - y[3])) - ((x[2] * y[3] - y[2] * x[3]) * (y[0] - y[1]));
		float p2Parent = ((x[0] - x[1]) * (y[2] - y[3])) - ((x[2] - x[3]) * (y[0] - y[1]));
		
		cp[0] = p1Son / p1Parent;
		cp[1] = p2Son / p2Parent;
		
		return cp;
	}
	
	public String isSameLine(int[] x, int[] y) {
		
		if((x[0] == x[2] && y[0] == y[2]) && (x[1] == x[3]) && (y[1] == y[3])) {
			System.out.println("1");
			return "LINE";
		}
		
		if((x[0] == x[3] && y[0] == y[3]) && (x[1] == x[2]) && (y[1] == y[2])) {
			System.out.println("2");
			return "LINE";
		}
		
		if(((x[0] - x[1]) * (y[2] - y[3])) - ((y[0] - y[1]) * (x[2] - x[3])) == 0) {
			return "NONE";
		}
		
		return "POINT";
	}

}
