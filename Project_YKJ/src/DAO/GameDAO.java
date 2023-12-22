package DAO;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Battle.Stage;
import Battle.StageBattle;
import Battle.StageLobby;
import Battle.StageTitle;

public class GameDAO {
	Random random = new Random();
	public static Scanner scan = new Scanner(System.in);
	public static String nextStage = "";
	public String curStage = "";
	public static Map<String, Stage> stageList = new HashMap<String, Stage>();

	public GameDAO() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		nextStage = "TITLE";
	}

	public boolean changeStage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		if (curStage.equals(nextStage))
			return true;
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();
		boolean run = true;
		while (true) {
			run = stage.update();
			if (run == false)
				break;
		}
		if (nextStage.equals(""))
			return false;
		else
			return true;
	}
}
