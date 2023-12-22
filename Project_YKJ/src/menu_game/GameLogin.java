package menu_game;

import DAO.UserDAO;
import Util.Util;
import _Game.GameCommand;

public class GameLogin implements GameCommand {
//	private GameController gCon;

	public GameLogin() {
		init();
	}

	@Override
	public void init() {
//		gCon = GameController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== 로그인창 ===");
		String id = Util.getValue("아이디");
		int idIdx = UserDAO.idValue(id);
		if (idIdx == -1) {
			System.out.println("ID 가 틀립니다");
			return true;
		}
		String pw = Util.getValue("비밀번호");
		int pwIdx = UserDAO.pwValue(pw);
		if (pwIdx == -1) {
			System.out.println("비밀번호가 틀립니다");
			return true;
		}
		System.out.println("로그인 완료");
		System.out.printf("닉네임 : %s %n", UserDAO.getuList().get(idIdx).getNickName());
		return false;
	}
}
