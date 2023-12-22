package Battle;

import DAO.GameDAO;

public class StageLobby implements Stage {
	@Override
	public boolean update() {
		System.out.println("=== LOBBY ===");
		System.out.println("[1. 전투]");
		System.out.println("[2. 종료]");
		int sel = GameDAO.scan.nextInt();
		if (sel == 1) {
			GameDAO.nextStage = "BATTLE";
		} else if (sel == 2) {
			GameDAO.nextStage = "";
		} else {
			GameDAO.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {
	}
}
