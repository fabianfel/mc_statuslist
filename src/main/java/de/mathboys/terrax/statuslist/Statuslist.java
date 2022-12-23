package de.mathboys.terrax.statuslist;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Criteria;

import java.util.HashMap;

public final class Statuslist extends JavaPlugin implements Listener {
    private HashMap<String, PlayerStatus> statusMap;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        this.statusMap = new HashMap<>();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String name = event.getPlayer().getName();
        event.getPlayer().sendMessage(Component.text("Hello, " + name + "!"));
        if (statusMap.get(name) == null) {
            statusMap.put(name, new PlayerStatus());
        }
        event.getPlayer().getScoreboard().registerNewObjective("Deaths", Criteria.DEATH_COUNT, Component.score("Deaths", "Deaths"));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        String name = event.getPlayer().getName();
        PlayerStatus status = this.statusMap.get(name);
        status.setDeaths(status.getDeaths() + 1);
    }

}