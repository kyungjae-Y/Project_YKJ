package Battle;

import DAO.GameDAO;

public class StageTitle implements Stage {
	@Override
	public boolean update() {
		System.out.println("=== TEXT RPG ===");
		System.out.println("[시작] 을 입력하세요");
		String start = GameDAO.scan.next();
		if (start.equals("시작"))
			GameDAO.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
	}
}
