package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import util.Problem;

public class Problem_12851 implements Problem {
	
	/*
	 * 12581 ¼û¹Ù²ÀÁú2(https://www.acmicpc.net/problem/12851)
	 */
	
	public static void main(String args[]) {
		Problem_12851 problem = new Problem_12851();
		
		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		Queue<Node> queue = new LinkedList<Node>();
		int[] visit = new int[200002];
		int[] move = {1, -1, 0};
		int cnt = 0;
		int minTime = 1000000000;
		
		for(int i = 0; i < 200002; i++)
			visit[i] = 0;
		
		queue.add(new Node(0, N));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int location = node.location;
			visit[location] = 1;
			int time = node.time;
			
			if(location == K) {
				if(time < minTime)
					minTime = time;
				
				if(time == minTime) {
					cnt++;
					continue;
				}
			}
			
			for(int i = 0; i < 3; i++) {
				int now;
				
				if(move[i] == 0) {
					now = location * 2;
				}
				else
					now = location + move[i];
				
				if(now >= 0 && now <= 100001) {
					if(visit[now] != 1) {
						queue.add(new Node(time + 1, now));
					}
				}
			}
			
		}

		System.out.println(minTime);
		System.out.println(cnt);
		scan.close();
	}
	
	public static class Node {
		int time;
		int location;
	
		public Node(int time, int location) {
			this.time = time;
			this.location = location;
		}
	}
}
