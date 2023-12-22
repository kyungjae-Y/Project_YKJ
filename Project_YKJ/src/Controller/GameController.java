package Controller;

import java.util.HashMap;
import java.util.Map;

import DAO.UserDAO;
import _Game.GameCommand;
import menu_game.GameJoin;
import menu_game.GameLogin;
import menu_game._MainGame;

public class GameController {
	private UserDAO uDAO;

	public UserDAO getuDAO() {
		return uDAO;
	}

	private GameController() {
		uDAO = new UserDAO();
		init();
	}

	private static GameController instance = new GameController();

	public static GameController getInstance() {
		return instance;
	}

	private Map<String, GameCommand> gameList;

	public void init() {
		gameList = new HashMap<>();
		gameList.put("GameMain", new _MainGame());
		gameList.put("GameJoin", new GameJoin());
		gameList.put("GameLogin", new GameLogin());
	}

	public GameCommand setNext(String key) {
		return gameList.get(key);
	}
}
