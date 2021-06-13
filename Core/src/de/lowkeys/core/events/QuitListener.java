package de.lowkeys.core.events;

import de.lowkeys.core.api.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        User.removeUser(User.getUserByPlayer(event.getPlayer()));
    }
}
