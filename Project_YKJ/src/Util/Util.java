package Util;

import java.util.Scanner;

public class Util {
	private static Scanner scan = new Scanner(System.in);

	public static int getValue(String msg, int start, int end) {
		while (true) {
			System.out.printf("▶ %s[%d-%d] 입력 : ", msg, start, end);
			try {
				int num = scan.nextInt();
				scan.nextLine();
				if (num < start || num > end) {
					System.out.println(start + " ~ " + end + " 값 입력해주세요");
					continue;
				}
				return num;
			} catch (Exception e) {
				scan.nextLine();
				System.err.println("숫자값을 입력해주세요");
			}
		}
	}

	public static String getValue(String msg) {
		System.out.printf("▶ %s 입력 : ", msg);
		return scan.next();
	}

	public static void closeScanner() {
		scan.close();
	}
}
