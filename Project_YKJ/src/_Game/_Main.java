package _Game;

import Controller.GameController;

public class _Main {
	public static void main(String[] args) {
		GameController gCon = GameController.getInstance();
		gCon.init();
		boolean run = true;
		while (true) {
			run = gCon.setNext("GameMain").update();
		}
	}
}
