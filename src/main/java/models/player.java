package models;

import utility.Stats;

public class player {
    private Stats stats;

    public player() {
        this.stats = new Stats(10,2,2,0,0, 300);
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
