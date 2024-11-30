package hust.soict.dsai.huststack;

import java.util.Scanner;

public class ConcatString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length1 = sc.nextInt();
		sc.nextLine();
		String inp1 = sc.nextLine();
		int length2 = sc.nextInt();
		sc.nextLine();
		String inp2 = sc.nextLine();
		if(length1 != inp1.length() || length2!=inp2.length()) {
			return;
		}
		int k = sc.nextInt();
		int t = sc.nextInt();
		
		StringBuilder newString = new StringBuilder();
		
		for(int i = 0;i<k;i++) {
			newString.append(inp1);
		}
		for(int i = 0;i<t;i++) {
			newString.append(inp2);
		}
		System.out.println(newString);
		sc.close();
	}
}


