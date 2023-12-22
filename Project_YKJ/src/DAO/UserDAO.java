package DAO;

import java.util.ArrayList;

import DTO.User;

public class UserDAO {
	private static ArrayList<User> uList;

	public UserDAO() {
		uList = new ArrayList<User>();
	}

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	public static ArrayList<User> getuList() {
		return uList;
	}

	// id || pw 중복
	public static int idValue(String id) {
		for (int i = 0; i < uList.size(); i++) {
			if (id.equals(uList.get(i).getId())) {
				return i;
			}
		}
		return -1;
	}

	public static int pwValue(String pw) {
		for (int i = 0; i < uList.size(); i++) {
			if (pw.equals(uList.get(i).getPw())) {
				return i;
			}
		}
		return -1;
	}

	public static int nnValue(String nickName) {
		for (int i = 0; i < uList.size(); i++) {
			if (nickName.equals(uList.get(i).getNickName())) {
				return i;
			}
		}
		return -1;
	}
}
