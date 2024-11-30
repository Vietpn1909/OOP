package hust.soict.dsai.huststack;

import java.util.Scanner;

public class countandreplace {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			int length = sc.nextInt();
			sc.nextLine();
			String inp = sc.nextLine();
			char target = sc.nextLine().charAt(0);
			char replace = sc.nextLine().charAt(0);

			if (inp.length() != length) {
				return;
			}

			int cnt = 0;
			StringBuilder newString = new StringBuilder(inp);

			for (int i = 0; i < newString.length(); i++) {
				if (newString.charAt(i) == target) {
					cnt++;
					newString.setCharAt(i, replace);
				}
			}
			System.out.println(cnt + " " + newString);
			sc.close();
		}
}
