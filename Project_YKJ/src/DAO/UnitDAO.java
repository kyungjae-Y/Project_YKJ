package DAO;

import java.util.ArrayList;
import java.util.Random;

import DTO.Player;
import DTO.Unit;

public class UnitDAO {
	public ArrayList<Player> playerList = new ArrayList<>();
	public ArrayList<Unit> unitList = new ArrayList<>();
	public String path = Unit.class.getPackageName() + ".";
	public String monsters[] = { "UnitM", "UnitS", "UnitB" };
	Random random = new Random();

	public UnitDAO() {
		playerList.add(new Player("전사", random.nextInt(50) + 1000, random.nextInt(10) + 30));
		playerList.add(new Player("해적", random.nextInt(50) + 800, random.nextInt(10) + 60));
		playerList.add(new Player("궁수", random.nextInt(50) + 700, random.nextInt(10) + 50));
		playerList.add(new Player("도적", random.nextInt(50) + 600, random.nextInt(10) + 40));
		playerList.add(new Player("마법사", random.nextInt(50) + 500, random.nextInt(10) + 50));
	}

	public void monster_random_set(int size) {
		for (int i = 0; i < size; i++) {
			int num = random.nextInt(monsters.length);
			try {
				Class<?> clazz = Class.forName(path + monsters[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;
				int hp = random.nextInt(100) + 500;
				int pos = random.nextInt(10) + 10;
				temp.init(hp, pos);
				unitList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}