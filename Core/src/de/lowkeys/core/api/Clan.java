package de.lowkeys.core.api;

import java.util.ArrayList;

public class Clan {
    private String name;
    private User leader;

    private ArrayList<User> memberList;

    public Clan(String name, User leader) {
        memberList = new ArrayList<>();

        this.name = name;
        this.leader = leader;
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
}
