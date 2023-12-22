package menu_game;

//import Controller.GameController;
import DAO.UserDAO;
import DTO.User;
import Util.Util;
import _Game.GameCommand;

public class GameJoin implements GameCommand {
//	private GameController gCon;

	public GameJoin() {
		init();
	}

	@Override
	public void init() {
//		gCon = GameController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== 회원가입창 ===");
		String id = Util.getValue("아이디");
		int idIdx = UserDAO.idValue(id);
		if (idIdx != -1) {
			System.out.println("중복 ID 가 존재");
			return true;
		}
		String pw = Util.getValue("비밀번호");
		String nickName = Util.getValue("닉네임");
		int nnIdx = UserDAO.nnValue(nickName);
		if (nnIdx != -1) {
			System.out.println("중복 닉네임이 존재");
			return true;
		}
		UserDAO.getuList().add(new User(id, pw, nickName));
		System.out.printf("%s, %s, %s 가입 완료 %n", id, pw, nickName);
		return false;
	}
}
