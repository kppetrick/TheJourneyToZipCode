import com.sun.org.apache.xpath.internal.operations.Bool;
import console.ConsoleManager;
import display.Display;
import models.player;



public class TheAdventure {
    private static player player;
    private static Display gameDisplay = new Display();
    private static ConsoleManager gameConsole = new ConsoleManager();
    public static void main(String[] args) {
        new TheAdventure();
    }

    public TheAdventure() {
        player = new player();
        gameDisplay.printMessage("\u001B[47m\u001B[30mYou awake from a night of very little sleep due to ZipCode...\n" +
                "Your Google calendar alarm goes off reminding you that you need \n" +
                "to turn in your project to Nobles in \033[1" + player.getStats().getTime().toString());
        currentStats();
        homeMessage();
        homeSwitch();
    }

    private void homeSwitch() {
        switch (gameConsole.playerInput()) {
            case "coffee":
                coffeeSelection();
                break;
            case "car":
                carSelection();
                break;
            case "eat":
                breakfastSelection();
                break;
            case "work":
                projectSelection();
                break;
            default:
                gameDisplay.printMessage("Invalid entry try again!");
                homeSwitch();
                homeMessage();
                break;
        }
    }

    private void carSwitch() {
        switch (gameConsole.playerInput()) {
            case "zipcode":
                zipcodeSelection();
                break;
            case "starbucks":
                starbucksSelection();
                break;
            case "gas":
                gasSelection();
                break;
            default:
                gameDisplay.printMessage("Invalid entry try again!");
                carSwitch();
                break;
        }
    }

    private void starbucksSwitch() {
        switch (gameConsole.playerInput()) {
            case "coffee":
                starbucksCoffeeSelection();
                break;
            case "project":
                starbucksProjectSelection();
                break;
            case "eat":
                starBucksEatSelection();
                break;
            case "leave":
                leaveStarbucksMessage();
                break;
            default:
                gameDisplay.printMessage("Invalid entry try again!");
                starbucksMessage();
                starbucksSwitch();
        }
    }

    private void lastChanceSwitch() {
        switch (gameConsole.playerInput()) {
            case "coffee":
                player.getStats().setAlertness(player.getStats().getAlertness() + 4);
                player.getStats().setTime(player.getStats().getTime() - 15);
                turnInMessage();
                break;
            case "work":
                player.getStats().setProject(player.getStats().getProject() + 2);
                player.getStats().setTime(player.getStats().getTime() - 15);
                turnInMessage();
                break;
            case "snack":
                player.getStats().setHunger(player.getStats().getHunger() + 2);
                player.getStats().setTime(player.getStats().getTime() - 30);
                turnInMessage();
                break;
            default:
                gameDisplay.printMessage("Invalid entry try again!");
                lastChanceMessage();
                lastChanceSwitch();
        }
    }

    private void gasSelection() {
        player.getStats().setTime(player.getStats().getTime() - 15);
        gameDisplay.printMessage("You fill up on gas! Looked like you were getting low!");
        currentStats();
        carMessage();
        carSwitch();
    }

    private void zipcodeSelection() {
        player.getStats().setTime(player.getStats().getTime() - 60);
        gameDisplay.printMessage("You arrive at zipcode!");
        currentStats();
        zipcodeMessage();
        lastChanceSelection();
    }

    private void starbucksSelection() {
        player.getStats().setTime(player.getStats().getTime() - 30);
        gameDisplay.printMessage("You arrive at Starbucks");
        currentStats();
        starbucksMessage();
        starbucksSwitch();
    }

    private void projectSelection() {
        if (player.getStats().getProject() != 0) {
            gameDisplay.printMessage("It is already completed get a move on!");
            homeMessage();
            homeSwitch();
        } else {
            player.getStats().setProject(player.getStats().getProject() + 4);
            player.getStats().setTime(player.getStats().getTime() - 30);
            gameDisplay.printMessage("You knock out some of this dang project");
            currentStats();
            homeMessage();
            homeSwitch();
        }
    }

    private void starbucksProjectSelection() {
        if (player.getStats().getProject() == 8) {
            gameDisplay.printMessage("You should get a move on!");
        } else {
            player.getStats().setProject(player.getStats().getProject() + 4);
            player.getStats().setTime(player.getStats().getTime() - 30);
            gameDisplay.printMessage("You knock out some of this dang project");
        }
        currentStats();
        starbucksMessage();
        starbucksSwitch();
    }

    public void coffeeSelection() {
        if (player.getStats().getAlertness() != 2) {
            gameDisplay.printMessage("I don't think you need more coffee right now.");
        } else {
            player.getStats().setAlertness(player.getStats().getAlertness() + 4);
            player.getStats().setTime(player.getStats().getTime() - 15);
            gameDisplay.printMessage("You gained 4 alertness!");
        }
        currentStats();
        homeMessage();
        homeSwitch();
    }

    public void starbucksCoffeeSelection() {
        if (player.getStats().getAlertness() == 10) {
            gameDisplay.printMessage("I don't think you need more coffee right now.");
        } else {
            player.getStats().setAlertness(player.getStats().getAlertness() + 4);
            player.getStats().setTime(player.getStats().getTime() - 15);
            gameDisplay.printMessage("You gained 4 alertness!");
        }
        currentStats();
        starbucksMessage();
        starbucksSwitch();
    }

    public void breakfastSelection() {
        if (player.getStats().getHunger() != 2) {
            gameDisplay.printMessage("I don't think you need to eat anymore right now.");
        } else {
            player.getStats().setHunger(player.getStats().getHunger() + 4);
            player.getStats().setTime(player.getStats().getTime() - 30);
            gameDisplay.printMessage("You make a yummy sausage egg and cheese sandwich you feel less hungry");
        }
        currentStats();
        homeMessage();
        homeSwitch();
    }

    public void starBucksEatSelection() {
        if (player.getStats().getHunger() == 10) {
            gameDisplay.printMessage("I don't think you need to eat anymore right now.");
        } else {
            player.getStats().setHunger(player.getStats().getHunger() + 4);
            player.getStats().setTime(player.getStats().getTime() - 30);
            gameDisplay.printMessage("You get a caprese flatbread!");
        }
        currentStats();
        starbucksMessage();
        starbucksSwitch();
    }

    public void carSelection() {
        gameDisplay.printMessage("You sure you wanna leave?\n" +
                "\033[yes] [no]\u001B");
        leaveHomeSelection();
    }

    public void leaveStarbucksMessage() {
        gameDisplay.printMessage("You sure you wanna leave?\n" +
                "\033[1;93m[yes] [no]\u001B");
        leaveStarbucksSelection();
    }
    private void leaveHomeSelection() {
        switch (gameConsole.playerInput()) {
            case "yes":
                currentStats();
                carMessage();
                carSwitch();
                break;
            case "no":
                currentStats();
                homeMessage();
                homeSwitch();
                break;
        }
    }
    private void leaveStarbucksSelection() {
        switch (gameConsole.playerInput()) {
            case "yes":
                currentStats();
                carMessage();
                carSwitch();
                break;
            case "no":
                currentStats();
                starbucksMessage();
                starbucksSwitch();
                break;
        }
    }

    private void lastChanceSelection() {
        switch (gameConsole.playerInput()) {
            case "yes":
                lastChanceMessage();
                lastChanceSwitch();
                break;
            case "no":
                turnInMessage();
                break;
        }
    }

    private String zipcodeMessage() {
        return gameDisplay.printMessage("You arrived! Any last minute things you need to do before turning the project in? + \n" +
                "\"\033[1;93m[yes] [no]\u001B[30m\"");
    }

    private String lastChanceMessage() {
        return gameDisplay.printMessage("Grab a\033[1;93m[coffee]\u001B[30m, grab a\033[1;93m[snack]\u001B[30mor cram some last minute\033[1;93m[work]\u001B[30m");
    }

    private String turnInMessage() {
        String result = "";
        if(player.getStats().getAlertness() < 5) result += "Looking a bit tired... \n";
        if(player.getStats().getHunger() < 5) result += "Looking a bit hungry... \n";
        if(player.getStats().getTime() < 60) result += "Cutting it a bit close are we? \n";
        if(player.getStats().getProject() == 0) result += "Im not mad I am just disappointed \n";
        if(player.getStats().getProject() == 4) result += "This is 'F' for fine \n";
        if(player.getStats().getProject() == 8) result += "I am not quite sure I can give this a satisfactory but its not terrible \n";
        if(player.getStats().getProject() == 10) result += "Nice work here are 5 more labs \033[1;93m*demonic laugh*";
        return gameDisplay.printMessage(result);
    }

    public String carMessage() {
        return gameDisplay.printMessage("\u001B[30mWhat do you do: \n" +
                "Drive to zipcode \033[1;93m[zipcode]\u001B[30m,\033[1;93m[starbucks]\u001B[30m or fill up\033[1;93m[gas]\u001B[30m.");
    }

    public String starbucksMessage() {
        return gameDisplay.printMessage("\u001B[30mWhat do you do: \n" +
                "Grab a cup of\033[1;93m[coffee]\u001B[30m, do more of the\033[1;93m[project]\u001B[30m," +
                "make breakfast\033[1;93m[eat]\u001B[30m or\033[1;93m[leave]\u001B[30m.");
    }

    public String homeMessage() {
        return gameDisplay.printMessage("\u001B[30mWhat do you do: \n" +
                "Grab a cup of\033[1;93m[coffee]\u001B[30m, Get in the\033[1;93m[car]\u001B[30m," +
                "Make breakfast\033[1;93m[eat]\u001B[30m, Do some\033[1;93m[work]\u001B[30mon your project.");
    }

    public String currentStats() {
        return gameDisplay.printMessage("\u001B[47m\u001B[30mYour current status is as follows:\n" +
                "Health: \033[1;93m" + player.getStats().getHealth().toString() + "/10\u001B[47m\u001B[30m " +
                "Alertness: \033[1;93m" + player.getStats().getAlertness().toString() + "/10\u001B[47m\u001B[30m " +
                "Hunger: \033[1;93m" + player.getStats().getHunger().toString() + "/10\u001B[47m\u001B[30m " +
                "Project: \033[1;93m" + player.getStats().getProject().toString() + "/10\u001B[47m\u001B[30m " +
                "Distance: \033[1;93m" + player.getStats().getDistance().toString() + "/10\u001B[47m\u001B[30m " +
                "Time: \033[1;93m" + player.getStats().getTime().toString() + " minutes\u001B[47m\u001B[30m");
    }


}
