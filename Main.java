package main;
import java.util.*;
import java.awt.Desktop;
import java.io.*;
import java.net.URI;

public class Main{
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("*********Zikrullah Password co.*********");
		System.out.println("Enter 1 for chrome setup");
		System.out.println("Enter 2 for non-chrome setup");
		System.out.println("****************************************");
		int com = in.nextInt();
		switch(com) {
			case 1 : {chromeSetup();break;}
			case 2 : {nonchromeSetup();break;}
			default : {System.out.println("Please select valid option");break;}
		}
	}
	public static void chromeSetup() throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("*********Chrome Setup*********");
		System.out.println("Enter 1 to Encode");
		System.out.println("Enter 2 to Decode and open in Chrome");
		System.out.println("Enter 3 for Main menu");
		System.out.println("****************************************");
		int com = in.nextInt();
		switch(com) {
			case 1 : {encodeChrome();break;}
			case 2 : {decodeChrome();break;}
			case 3 : {main(new String[] {});break;}
			default : {System.out.println("Please enter valid option");break;}
		}
	}
	public static void nonchromeSetup() throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("*********Non Chrome Setup*********");
		System.out.println("Enter 1 to Encode");
		System.out.println("Enter 2 to Decode");
		System.out.println("Enter 3 for restart");
		System.out.println("****************************************");
		int com = in.nextInt();
		switch(com) {
			case 1 : {encode(); break;}
			case 2 : {decode() ;break;}
			case 3 : {main(new String[] {});break;}
			default : {System.out.println("Please enter valid option");break;}
		}
	}
	
	public static void encode() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Data");
		String s = in.nextLine();
		s = s.trim();
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
	public static void encodeChrome() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Data");
		String s = in.nextLine();
		s = s.trim();
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
		en.append(s.length());
		System.out.println(en.toString());
	}
	
	public static void decode() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Cypher text");
		String s = in.nextLine();
		s = s.trim();
		int sq = sqrRt(s.length());
		int n;
		if(s.length()==sq*sq) {
			n = sqrRt(s.length());
		}else {
			n = sqrRt(getCode(s.length()));
		}
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
	public static void decodeChrome() throws Exception{
		System.err.println("Cautions : DO NOT PASTE LAST APPENDED DIGIT");
		Scanner in = new Scanner(System.in);
		boolean toClean = false;
		System.out.println("Enter Cypher text");
		String s = in.nextLine();
		s = s.trim();
		char l = s.charAt(s.length()-1);
		int length = Character.getNumericValue(l);
		StringBuilder sb = new StringBuilder(s);
		s = sb.toString();
		int sq = sqrRt(s.length());
		int n;
		if(s.length()==sq*sq) {
			n = sqrRt(s.length());
		}else {
			toClean = true;
			n = sqrRt(getCode(s.length()));
		}
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
		String cleaned_code = cleanCode(en);
		chrome(cleaned_code);
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
	public static void chrome(String url) throws Exception{
		Desktop desk = Desktop.getDesktop();
        desk.browse(new URI(url));
	}
	public static String cleanCode(StringBuilder s) {
		System.out.println(s);
		int index = s.length()-1;
		for(;index>=0;) {
			if(s.charAt(index)=='.') {
				index--;
			}else {
				break;
			}
		}
		s.delete(index, s.length());
		return s.toString();
	}
}