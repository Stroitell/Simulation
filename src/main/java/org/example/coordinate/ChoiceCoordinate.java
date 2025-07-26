package org.example.coordinate;

import org.example.worldMap.WorldMap;

import java.util.List;
import java.util.Random;

public class ChoiceCoordinate {

    private final Random random = new Random();

    public Coordinate chooseCoordinate (WorldMap worldMap){
        List<Coordinate> coordinates = worldMap.getEmptyCoordinates();
        return coordinates.get(random.nextInt(coordinates.size()));
    }
}
