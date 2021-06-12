package main;
import java.util.*;
import java.awt.Point;
public class Main extends Thread{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeMap<Integer,Integer> map = new TreeMap<>();
		int n = in.nextInt();
		int[] ans = new int[n];
		for(int i = 0;i<n;i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			Integer prev = map.floorKey(start);
			Integer next = map.ceilingKey(end);
			System.out.println(map);
			System.out.println(prev+" "+next);
			if((prev == null || map.get(prev) <= start) && (next == null || end <= next)) {
				map.put(start, end);
				ans[i] = 1;
			}else {
				ans[i] = 0;
			}
		}
		for(int i : ans) {
			System.out.print(i+" ");
		}
	}
 }

/*10 20
15 35
40 50
45 55
20 30*/