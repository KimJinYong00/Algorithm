package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import util.Problem;

public class Problem_14729 implements Problem {
	
	/*
	 * 14792 Ä¥¹«ÇØ (https://www.acmicpc.net/problem/14729)
	 */
	
	public static void main(String args[]) {
		Problem_14729 problem = new Problem_14729();
		problem.solve();
	}
	
	@Override
	public void solve() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine().toString());
			PriorityQueue<Float> queue = new PriorityQueue<Float>(7, Collections.reverseOrder());
	
			float max = 0, input;
			for(int i = 0; i < 7; i++) {
				queue.add(Float.valueOf(br.readLine().toString()));
			}
	
			for(int i = 7; i < N; i++) {
				input = Float.valueOf(br.readLine().toString());
				max = queue.poll();
				if(max > input)
					queue.offer(input);
				else
					queue.offer(max);
				
			}
			br.close();
			float[] output = new float[7];
			for(int i = 6; i >= 0; i--)
				output[i] = queue.poll();
			for(int i = 0; i < 7; i++)
				System.out.format("%.3f\n", output[i]);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
