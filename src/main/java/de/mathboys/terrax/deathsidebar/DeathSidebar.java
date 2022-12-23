package de.mathboys.terrax.deathsidebar;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public final class DeathSidebar extends JavaPlugin implements Listener {
    private Scoreboard scoreboard;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective obj = scoreboard.getObjective("Deaths");
        if (obj == null) {
            obj = this.scoreboard.registerNewObjective("Deaths", Criteria.DEATH_COUNT, Component.text("Deaths"));
        }
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setScoreboard(scoreboard);
    }
}