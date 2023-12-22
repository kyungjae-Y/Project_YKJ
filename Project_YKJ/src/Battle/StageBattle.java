package Battle;

import java.util.ArrayList;
import java.util.Random;

import DAO.GameDAO;
import DAO.UnitDAO;
import DTO.Player;
import DTO.Unit;

public class StageBattle implements Stage {
	UnitDAO unitDAO = new UnitDAO();
	ArrayList<Player> playerList = null;
	ArrayList<Unit> monsterList = null;
	Random random = new Random();
	int monster_dead = 0;
	int player_dead = 0;

	@Override
	public void init() {
		unitDAO.unitList.clear();
		unitDAO.monster_random_set(5);
		playerList = null;
		playerList = unitDAO.playerList;
		monsterList = null;
		monsterList = unitDAO.unitList;
		monster_dead = monsterList.size();
		player_dead = playerList.size();
	}

	void print_character() {
		while (true) {
			System.out.println("=== 배틀 시작 ===");
			System.out.println("=== PLAYER ===");
			for (int i = 0; i < playerList.size(); i++) {
				playerList.get(i).printData();
			}
			System.out.println("=== MONSTER ===");
			for (int i = 0; i < monsterList.size(); i++) {
				monsterList.get(i).printData();
			}
		}
	}

	void player_attack(int index) {
		Player p = playerList.get(index);
		if (p.curHp <= 0)
			return;
		System.out.println("[" + p.name + "] 의 선택");
		System.out.println("[1. 공격]");
		System.out.println("[2. 스킬]");
		int sel = GameDAO.scan.nextInt();
		if (sel == 1) {
			while (true) {
				int idx = random.nextInt(monsterList.size());
				if (monsterList.get(idx).curHp > 0) {
					p.attack(monsterList.get(idx));
					break;
				}
			}
		} else if (sel == 2) {
			while (true) {
				int idx = random.nextInt(monsterList.size());
				if (monsterList.get(idx).curHp > 0) {
					p.skill(monsterList.get(idx));
					break;
				}
			}
		}
	}

	void monster_attack(int index) {
		Unit mon = monsterList.get(index);
		if (mon.curHp <= 0)
			return;
		while (true) {
			int idx = random.nextInt(playerList.size());
			if (playerList.get(idx).curHp > 0) {
				mon.attack(playerList.get(idx));
				break;
			}
		}
	}

	void check_live() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).curHp <= 0) {
				num += 1;
			}
		}
		player_dead = playerList.size() - num;
		num = 0;
		for (int i = 0; i < monsterList.size(); i++) {
			if (monsterList.get(i).curHp <= 0) {
				num += 1;
			}
		}
		monster_dead = monsterList.size() - num;
	}

	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;
		while (run) {
			if (turn) {
				print_character();
				if (p_index < playerList.size()) {
					player_attack(p_index);
					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}
			} else if (!turn) {
				if (m_index < monsterList.size()) {
					monster_attack(m_index);
					m_index += 1;
				} else {
					turn = !turn;
					m_index = 0;
				}
			}
			check_live();
			if (monster_dead <= 0 || player_dead <= 0)
				break;
		}
		GameDAO.nextStage = "LOBBY";
		return false;
	}
}
