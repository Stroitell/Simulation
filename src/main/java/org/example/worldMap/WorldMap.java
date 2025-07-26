package org.example.worldMap;

import org.example.coordinate.Coordinate;
import org.example.coordinate.CoordinateComparator;
import org.example.entity.Creature;
import org.example.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WorldMap {
    private int numberRock = 17;
    private int startNumberGrass = 25;

    private int numberPredators = 4;
    private int numberHerbivores = 8;

    private final int minNumberPredators = 2;
    private final int minNumberHerbivores = 4;

    private final int [] SIZE_MAP = {10, 10};
    private final int WIDTH = SIZE_MAP[0];
    private final int HEIGHT = SIZE_MAP[1];

    private final Map<Coordinate, Entity> entityMap = new HashMap<>();
    private final List<Coordinate> emptyCoordinates = setAllWorldMapCoordinate();
    private final List<Creature> creatures = new LinkedList<>();

    public List<Coordinate> setAllWorldMapCoordinate (){
        List<Coordinate> allWorldMapCoordinate = new ArrayList<>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                allWorldMapCoordinate.add(new Coordinate(x, y));
                allWorldMapCoordinate.sort(new CoordinateComparator());
            }
        }
        return allWorldMapCoordinate;
    }


    public List<Creature> getCreatures() {
        return creatures;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public List<Coordinate> getEmptyCoordinates() {
        return emptyCoordinates;
    }

    public Map<Coordinate, Entity> getEntityMap() {
        return entityMap;
    }

    public int getMinNumberPredators() {
        return minNumberPredators;
    }

    public int getMinNumberHerbivores() {
        return minNumberHerbivores;
    }

    public int getNumberPredators() {
        return numberPredators;
    }

    public int getNumberHerbivores() {
        return numberHerbivores;
    }

    public int getStartNumberGrass() {
        return startNumberGrass;
    }

    public int getNumberRock() {
        return numberRock;
    }

    public void decrementNumberPredator() {
        numberPredators--;
    }

    public void decrementNumberHerbivore() {
        numberHerbivores--;
    }

    public void incrementNumberPredator(int count){
        numberPredators = numberPredators + count;
    }

    public void incrementNumberHerbivore(int count) {
        numberHerbivores = numberHerbivores + count;
    }


}
