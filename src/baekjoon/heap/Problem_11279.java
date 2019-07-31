package baekjoon.heap;

import java.util.Scanner;

import util.Problem;

public class Problem_11279 implements Problem {

	/*
	 * 11279 최대힙 (https://www.acmicpc.net/problem/11279)
	 */
	
	public static void main(String[] args) {
		Problem_11279 problem = new Problem_11279();
		
		problem.solve();
	}
	
	int HEAP_IDX = 0;
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[] heap = new int[100001];
		
		for(int i = 0; i < N; i++) {
			int x = scan.nextInt();
			
			if(x == 0) {
				System.out.println(pop(heap));
			}
			else {
				push(heap, x);
//				print(heap);
			}
		}
		
		scan.close();
	}
	
	public void push(int[] heap, int value) {
		heap[++HEAP_IDX] = value;
		
		int i = HEAP_IDX;
		while(i > 0) {
			if(i / 2 < 1) {
				break;
			}
			
			if(heap[i / 2] < heap[i]) {
				int temp = heap[i];
				
				heap[i] = heap[i / 2];
				heap[i / 2] = temp;
				i = i / 2;
			}
			else {
				break;
			}
		}
	}
	
	public int pop(int[] heap) {
		if(HEAP_IDX == 0)
			return HEAP_IDX;
		
		int result = heap[1];
		
		heap[1] = heap[HEAP_IDX--];
		
		int i = 1;
		
		while(i < HEAP_IDX) {
			int leftChildIdx = i * 2;
			int rightChildIdx = i * 2 + 1;
			int maxIdx;
			if(leftChildIdx > HEAP_IDX) {
				break;
			}
			
			if(rightChildIdx > HEAP_IDX) {
				maxIdx = leftChildIdx;
			}
			else {
				if(heap[leftChildIdx] < heap[rightChildIdx]) {
					maxIdx = rightChildIdx;
				}
				else {
					maxIdx = leftChildIdx;
				}
			}
			
			if(heap[i] < heap[maxIdx]) {
				int temp = heap[i];
				
				heap[i] = heap[maxIdx];
				heap[maxIdx] = temp;
				i = maxIdx;
			}
			else {
				break;
			}
		}
		
		return result;
	}
	
	public void print(int[] heap) {
		for(int i = 1; i <= HEAP_IDX; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
}
