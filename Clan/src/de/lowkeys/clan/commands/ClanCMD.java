package de.lowkeys.clan.commands;

import de.lowkeys.core.api.Clan;
import de.lowkeys.core.api.Common;
import de.lowkeys.core.api.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClanCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;
        User user = User.getUserByPlayer(player);

        if(strings.length == 0) {
            if(!player.hasPermission("lowkeys.clan.clan")) {
                player.sendMessage(Common.getNoPerms());
                return false;
            }
            if(user.getClan() == null) {
                player.sendMessage(Common.getPrefix() + "§7You §6aren't§7 currently in a clan!");
                return false;
            }
            player.sendMessage(Common.getPrefix() + "§7You're in the clan §6" + user.getClan().getName());
            player.sendMessage(Common.getPrefix() + "§7Leader: §6" + user.getClan().getLeader().getPlayer().getDisplayName());
            player.sendMessage(Common.getPrefix() + "§7Members: §6" + user.getClan().getMemberList().length);
        }
        if(strings.length == 1) {
            if(strings[0].equalsIgnoreCase("leave")) {
                if(!player.hasPermission("lowkeys.clan.leave")) {
                    player.sendMessage(Common.getNoPerms());
                    return false;
                }

                if(user.getClan() == null) {
                    player.sendMessage(Common.getPrefix() + "§7You're §6not§7 in a §6clan§7!");
                    return false;
                }


            }
        }
        if(strings.length == 2) {
            if(strings[0].equalsIgnoreCase("create")) {
                if(!player.hasPermission("lowkeys.clan.create")) {
                    player.sendMessage(Common.getNoPerms());
                    return false;
                }
                if(user.getClan() != null) {
                    player.sendMessage(Common.getPrefix() + "§7You are §6currently §7in a §6clan§7!");
                    return false;
                }
                String clanName = strings[1];

                if(Clan.doesClanNameExists(clanName)) {
                    player.sendMessage(Common.getPrefix() + "§7This clan name §6exists§7!");
                    return false;
                }

                Clan clan = new Clan(clanName, user);
                player.sendMessage(Common.getPrefix() + "§7You created the clan §6" + clanName + "§7!");
            }
        }

        return false;
    }
}
