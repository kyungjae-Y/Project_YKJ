package DTO;

public abstract class Unit {
	public int curHp;
	public int maxHp;
	public int power;
	public String name;
	String difficulty = "노말";

	public Unit() {
	}

	public Unit(String na, int max, int pos) {
		name = na;
		maxHp = max;
		curHp = max;
		power = pos;
	}

	public void init(int max, int pos) {
		maxHp = max;
		curHp = max;
		power = pos;
	}

	public void init(String na, int max, int pos) {
		name = na;
		maxHp = max;
		curHp = max;
		power = pos;
	}

	public void attack(Unit target) {
		target.curHp -= power;
		System.out.println("[" + name + "]이" + " [" + target.name + "]에게 " + power + "의 데미지를 가함");
		if (target.curHp <= 0) {
			System.out.println("[" + target.name + "] 처치");
			target.curHp = 0;
		}
	}

	public void skill(Unit target) {
		target.curHp -= power * 2;
		System.out.println("[" + name + "]이" + " [" + target.name + "]에게 " + (power * 2) + "의 데미지를 가함");
		if (target.curHp <= 0) {
			System.out.println("[" + target.name + "] 처치");
			target.curHp = 0;
		}
	}

	public void printData() {
		System.out.println("[" + name + "] [" + curHp + " / " + maxHp + "] [" + power + "]");
	}
}
