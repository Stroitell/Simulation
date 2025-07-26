package org.example;

import org.example.actions.InitActions;
import org.example.actions.TurnActions;
import org.example.worldMap.WorldMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WorldMap worldMap = new WorldMap();
        InitActions.initActions(worldMap);

        TurnActions turnActions = new TurnActions(worldMap);
        turnActions.start();

        while (turnActions.getInput() != turnActions.getEndSimulation()) {
            if (turnActions.getInput() == turnActions.getStartSimulation()){
                turnActions.setInput(turnActions.getInput() + scanner.nextInt());
            }
            else {
                turnActions.setInput(scanner.nextInt());
            }
        }

    }
}