package de.lowkeys.core.api;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class User {
	private static ArrayList<User> allUser = new ArrayList<>();

	private Player player;
	private Clan clan;

	public User(Player player) {
		this.player = player;

		allUser.add(this);
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Player getPlayer() {
		return this.player;
	}
	public Clan getClan() {
		return this.clan;
	}

	public static User getUserByPlayer(Player player) {
		for(User user : allUser) {
			if(user.getPlayer().getUniqueId() == player.getUniqueId()) {
				return user;
			}
		}

		return null;
	}
	public static User[] getUsers() {
		return allUser.toArray(new User[0]);
	}
	public static void removeUser(User user) {
		allUser.remove(user);
	}
}
