package de.mathboys.terrax.statuslist;

public class PlayerStatus {
    private int deaths;
    private int playerKills;
    private int mobKills;

    public PlayerStatus() {
        this.deaths = 0;
        this.playerKills = 0;
        this.mobKills = 0;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getPlayerKills() {
        return playerKills;
    }

    public int getMobKills() {
        return mobKills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setPlayerKills(int playerKills) {
        this.playerKills = playerKills;
    }

    public void setMobKills(int mobKills) {
        this.mobKills = mobKills;
    }
}
