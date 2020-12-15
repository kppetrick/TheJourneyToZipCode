package display;

import models.player;

public class Display {
    private models.player player;

    public String printMessage(String textToDisplay) {
        System.out.println(textToDisplay);
        return textToDisplay;
    }

    public void printCharacterStats() {
            printMessage("Health: " + this.player.getStats().getHealth().toString() + "/10");
            printMessage("Alertness: " + this.player.getStats().getAlertness().toString() + "/10");
            printMessage("Hunger: " + this.player.getStats().getHunger().toString() + "/10");
            printMessage("Project: " + this.player.getStats().getProject().toString() + "/10");
            printMessage("Distance: " + this.player.getStats().getDistance().toString() +"/10");
            printMessage("Distance: " + this.player.getStats().getTime().toString() +"/10");
        }
    }

