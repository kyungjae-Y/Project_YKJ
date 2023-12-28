package kor;

import java.util.Random;
import java.util.Scanner;

import _Main.MovieGameMain;

public class KorMovie {

	Scanner sc = new Scanner(System.in);

	public void showKor() {
//		극한직업 실미도 왕의남자 청년경찰 해운대 엽기적인그녀 암살
//		랜덤으로 한 문제 뽑기
//		if 랜덤값이 초성문제면 consonant 를 
//		else if 랜덤값이 배우 문제면 actor 를,
//		else 랜덤값이 배우면 script 를 추출한다
		boolean isCorrect = false;
		int cnt = 0;
//		질문
		String[] questions = { "다음 초성에 맞는 영화는 무엇일까요 ??", "다음 배우들이 나오는 영화는 무엇일까요 ??", "다음 명대사가 나오는 영화는 무엇일까요 ??" };
//		초성
		String[] consonant = { "ㄱㅎㅈㅇ", "ㅅㅁㄷ", "ㅇㅇ ㄴㅈ", "ㅊㄴㄱㅊ", "ㅎㅇㄷ", "ㅇㄱㅈㅇ ㄱㄴ", "ㅇㅅ" };
//		배우
		String[] actor = { "이하늬 신하균", "설경구 안성기", "감우성 이준기", "박서준 강하늘", "설경구 하지원", "차태현 전지현", "이정재 하정우 전지현" };
//		명대사
		String[] script = { "응 ~ 나 화교 출신", "날 쏘고 가라,,,", "나는 두 말 할 거 없이 광대, 광대지", "졸라 과학수사!!", "저 괜찮아요 먼저 올라가요",
				"견우야 ~~ 미안해 ~", "나 약산의 김원봉이오" };
		Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random();
		Random rand4 = new Random();
		if (questions[rand1.nextInt(3)].equals(questions[0])) {
			System.out.println(questions[0]);
			System.out.println(consonant[rand2.nextInt(7)]);
		} else if (questions[rand1.nextInt(3)].equals(questions[1])) {
			System.out.println(questions[1]);
			System.out.println(actor[rand3.nextInt(7)]);
		} else {
			System.out.println(questions[2]);
			System.out.println(script[rand4.nextInt(7)]);
		}
		while (true) {
			System.out.print("입력 : ");
			String title = this.sc.nextLine();
			cnt += 1;
			switch (title) {
			case "극한직업":
				if (title.equals(consonant[0]) || title.equals(actor[0]) || title.equals(script[0]))
					System.out.println("극한직업 정답입니다");
				isCorrect = true;
				break;
			case "실미도":
				if (title.equals(consonant[1]) || title.equals(actor[1]) || title.equals(script[1]))
					System.out.println("실미도 정답입니다");
				isCorrect = true;
				break;
			case "왕의 남자":
				if (title.equals(consonant[2]) || title.equals(actor[2]) || title.equals(script[2]))
					System.out.println("왕의 남자 정답입니다");
				isCorrect = true;
				break;
			case "청년경찰":
				if (title.equals(consonant[3]) || title.equals(actor[3]) || title.equals(script[3]))
					System.out.println("청년경찰 정답입니다");
				isCorrect = true;
				break;
			case "해운대":
				if (title.equals(consonant[4]) || title.equals(actor[4]) || title.equals(script[4]))
					System.out.println("해운대 정답입니다");
				isCorrect = true;
				break;
			case "엽기적인 그녀":
				if (title.equals(consonant[5]) || title.equals(actor[5]) || title.equals(script[5]))
					System.out.println("엽기적인 그녀 정답입니다");
				isCorrect = true;
				break;
			case "암살":
				if (title.equals(consonant[6]) || title.equals(actor[6]) || title.equals(script[6]))
					System.out.println("암살 정답입니다");
				isCorrect = true;
				break;
			default:
				System.out.println("다시 시도하세요");
				isCorrect = false;
				break;
			}
			if (isCorrect)
				break;
		}
		System.out.println(cnt + " 번만에 성공하셨습니다");
	}

	public void more() {
		System.out.println("게임을 더 하시겠습니까? (Y/N)");
		String answer = sc.nextLine();
		MovieGameMain.finish = answer.equals("y") || answer.equals("Y") ? false : true;
	}
}