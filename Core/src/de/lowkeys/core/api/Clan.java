package de.lowkeys.core.api;

import java.util.ArrayList;

public class Clan {
    private static ArrayList<Clan> clanList = new ArrayList<>();
    private String name;
    private User leader;

    private ArrayList<User> memberList;

    public Clan(String name, User leader) {
        memberList = new ArrayList<>();

        this.name = name;
        this.leader = leader;
        leader.setClan(this);

        clanList.add(this);
    }

    public String getName() {
        return name;
    }
    public User getLeader() {
        return leader;
    }
    public User[] getMemberList() {
        return memberList.toArray(new User[0]);
    }

    public boolean isUserInClan(User user) {
        return memberList.contains(user);
    }

    public boolean addMember(User user) {
        if(!isUserInClan(user)) {
            memberList.add(user);
            return true;
        }

        return false;
    }
    public void removeMember(User user) {
        memberList.remove(user);
        user.setClan(null);
    }

    public static boolean doesClanNameExists(String clanName) {
        for(Clan clan : clanList) {
            if(clan.getName().equalsIgnoreCase(clanName)) {
                return true;
            }
        }

        return false;
    }
    public static Clan[] getClans() {
        return clanList.toArray(new Clan[0]);
    }
}
