package main;
import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("*********Zikrullah Password co.*********");
		System.out.println("Enter 1 to Encode");
		System.out.println("Enter 2 to Decode");
		int com = in.nextInt();
		switch(com) {
		case 1 : encode();
		case 2 : decode();
		}
	}
	
	public static void encode() {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int sq = sqrRt(s.length());
		char[][] mat;
		int n;
		if(s.length()==sq*sq) {
			mat = getMat(s,sqrRt(s.length()));
			n = sqrRt(s.length());
		}else {
			mat = getMat(s,sqrRt(getCode(s.length())));
			n = sqrRt(getCode(s.length()));
		}
		char[][] t = new char[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				t[i][j] = mat[j][i];
			}
		}
		StringBuilder en = new StringBuilder();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				en.append(t[i][j]);
			}
		}
		System.out.println(en.toString());
	}
	
	public static void decode() {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = sqrRt(s.length());
		char[][] mat = new char[n][n];
		int k = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				mat[i][j] = s.charAt(k++);
			}
		}
		char[][] at = new char[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				at[i][j] = mat[j][i];
			}
		}
		StringBuilder en = new StringBuilder();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				en.append(at[i][j]);
			}
		}
		System.out.println(en.toString());
	}
	
	public static char[][] getMat(String s, int n){
		char[][] mat = new char[n][n];
		int k = 0;
		int i = 0;
		int j = 0;
		for(i = 0;i<n;i++) {
			for(j= 0;j<n;j++) {
				if(k<s.length())
					mat[i][j] = s.charAt(k++);
				else
					mat[i][j] = '.';
			}
		}
//		if(s.length()==n*n) return mat;
//		for(;i<n;i++) {
//			for(;j<n;j++) {
//				mat[i][j] = '.';
//			}
//		}
		
		return mat;
	}
	public static void printMat(char[][] mat, int n) {
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int sqrRt(int n) {
		int low = 0;
		int high = n;
		while(low<=high) {
			int mid = (low+high)/2;
			if(mid*mid==n) {
				return mid;
			}else if(mid*mid<n) {
				low = mid+1;
			}else if(mid*mid>n) {
				high = mid-1;
			}
		}
		return -1;
	}
	public static int getCode(int n) {
		int nextN = (int)Math.floor(Math.sqrt(n))+1;
	    return nextN * nextN;
	}
}