package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import util.Problem;

public class Problem_2941 implements Problem {

	
	/*
	 * 4963 섬 개수 (https://www.acmicpc.net/problem/4963)
	 */
	public static void main(String[] args) {
		Problem_2941 problem = new Problem_2941();

		problem.solve();
	}
	
	@Override
	public void solve() {
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		
		System.out.println(replaceLiteral(str).length());
		
		scan.close();
	}
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	public void init() {
		map.put("dz=", 2);
		map.put("c=", 1);
		map.put("c-", 1);
		map.put("d-", 1);
		map.put("lj", 2);
		map.put("nj", 2);
		map.put("s=", 1);
		map.put("z=", 1);
	}
	
	public String replaceLiteral(String str) {
		
		for(String alpha : map.keySet()) {
			String addStr = "";
			
			if(map.get(alpha) == 2) {
				addStr = "aa";
			}
			else if(map.get(alpha) == 1) {
				addStr = "a";
			}
			
			str = str.replace(alpha, addStr);
		}
		
		return str;
	}
}
