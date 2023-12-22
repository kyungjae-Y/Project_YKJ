package menu_game;

import Controller.GameController;
import Util.Util;
import _Game.GameCommand;

public class _MainGame implements GameCommand {
	private GameController gCon;

	public _MainGame() {
		init();
	}

	@Override
	public void init() {
		gCon = GameController.getInstance();
	}

	@Override
	public boolean update() {
//		System.out.println("=== 메이플 스토리 ===");
		System.out.println("=== Game ===");
		System.out.println("[1] 회원가입");
		System.out.println("[2] 로그인");
		System.out.println("[0] 종료");
		int sel = Util.getValue("메뉴", 0, 2);
		if (sel == 0) {
			System.out.println("프로그램 종료");
			return false;
		}
		if (sel == 1) {
			gCon.setNext("GameJoin").update();
		} else if (sel == 2) {
			gCon.setNext("GameLogin").update();
		}
		return false;
	}
}
