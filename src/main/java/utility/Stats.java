package utility;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Stats {
    private Integer time;
    private Integer health;
    private Integer alertness;
    private Integer hunger;
    private Integer project;
    private Integer distance;

    public Stats(int health, int alertness, int hunger, int project, int distance, int time) {
        this.health = health;
        this.alertness = alertness;
        this.hunger = hunger;
        this.project = project;
        this.distance = distance;
        this.time = time;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAlertness() {
        return alertness;
    }

    public void setAlertness(Integer alertness) {
        this.alertness = alertness;
    }

    public Integer getHunger() {
        return hunger;
    }

    public void setHunger(Integer hunger) {
        this.hunger = hunger;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
