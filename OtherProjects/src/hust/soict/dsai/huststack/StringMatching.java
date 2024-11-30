package hust.soict.dsai.huststack;

import java.util.Scanner;

public class StringMatching {
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
		int i = 0;
		while( i<=inp1.length()-inp2.length()) {
			if(inp1.substring(i, i + inp2.length()).equals(inp2)) {
				System.out.print(i + " ");
			}
			i++;
		}
		sc.close();
	}
}

