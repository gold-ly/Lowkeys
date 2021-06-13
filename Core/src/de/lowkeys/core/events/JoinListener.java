package de.lowkeys.core.events;

import de.lowkeys.core.api.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        User user = new User(event.getPlayer());
    }
}
