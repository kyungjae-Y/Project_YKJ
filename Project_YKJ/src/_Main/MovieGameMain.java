package _Main;

import java.util.Scanner;

import kor.KorMovie;

public class MovieGameMain {
	String name;
	public static boolean finish = false;
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("==========================");
		System.out.println("    한국 영화 제목 맞추기 !     ");
		System.out.println("==========================");
		System.out.print("ID 를 입력해주세요 : ");
		String id = scan.nextLine();
		System.out.println(id + " 님 환영합니다 !");
		System.out.println("GAME START !!!!");
//		영화 장르 객체 생성
		KorMovie km = new KorMovie();
		while (!MovieGameMain.finish) {
//			문제 내기
			km.showKor();
//			게임 더 하기
			km.more();
		}
		System.out.println("게임을 종료합니다");
	}
}