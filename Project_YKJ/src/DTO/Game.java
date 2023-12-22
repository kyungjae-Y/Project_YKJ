package DTO;

public class Game {
	private String id;

	public Game(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "id : " + id;
	}
}
